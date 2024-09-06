package co.edu.unbosque.Taller_Rendimiento.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.RequestOrderDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.PedidoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

/**
 * Servicio para gestionar las operaciones relacionadas con pedidos en la entidad 
 * {@code PedidoEntity}. Utiliza {@code PedidoRepository} para las operaciones de acceso 
 * a datos y otros servicios para manejar la lógica de negocio relacionada con productos y clientes.
 * El servicio está anotado con {@code @Service} y maneja transacciones con {@code @Transactional}.
 */
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoService detallePedidoService;
    private final ClienteService clienteService;
    private final ProductoService productoService;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**
     * Constructor de {@code PedidoService}.
     * 
     * @param pedidoRepository El repositorio de pedidos a ser utilizado por el servicio.
     * @param detallePedidoService El servicio de detalles de pedidos a ser utilizado por el servicio.
     * @param clienteService El servicio de clientes a ser utilizado por el servicio.
     * @param productoService El servicio de productos a ser utilizado por el servicio.
     */
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, DetallePedidoService detallePedidoService,
                         ClienteService clienteService, ProductoService productoService) {
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoService = detallePedidoService;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    /**
     * Crea un pedido con sus detalles. Valida la existencia de productos y cantidades antes de 
     * guardar el pedido y sus detalles. Luego, programa la confirmación del pedido con un retraso.
     * 
     * @param requestOrderDTO El objeto que contiene la información del pedido y los detalles.
     * @return El pedido creado, representado por un {@code PedidoDTO}.
     * @throws Exception Si ocurre un error durante la validación, la creación del pedido o el guardado 
     *         de los detalles del pedido.
     */
    @Transactional
    public PedidoDTO crearPedidoConDetalles(RequestOrderDTO requestOrderDTO) throws Exception {
        PedidoDTO pedidoDTO = requestOrderDTO.getPedidoDTO();
        List<DetallePedidoDTO> detallesDTO = requestOrderDTO.getDetalleDTO();

 
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto());
            if (producto == null) {
                throw new Exception("El producto con ID " + detalleDTO.getId().getIdProducto() + " no existe.");
            }
            if (detalleDTO.getCantidad() <= 0) {
                throw new Exception("La cantidad para el producto con ID " + detalleDTO.getId().getIdProducto() + " debe ser mayor a 0.");
            }
        }

        PedidoDTO pedidoCreado = crearOrden(pedidoDTO);
        int idPedido = pedidoCreado.getIdPedido();
        float total = 0;

        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto());
            detalleDTO.setToralizado(detalleDTO.getCantidad() * producto.getPrecio());
            DetallePedidoDTO detalleGuardadoDTO = detallePedidoService.agregarDetallePedido(idPedido, detalleDTO);
            total += detalleGuardadoDTO.getToralizado();
        }

        pedidoCreado.setTotal(total);
        pedidoCreado.setnumeroTarjeta(pedidoDTO.getnumeroTarjeta());
        pedidoRepository.save(MapperUtilities.mapearObjetos(pedidoCreado, PedidoEntity.class));

        scheduleOrderConfirmation(idPedido);

        return pedidoCreado;
    }

    /**
     * Programa la confirmación de un pedido después de un retraso de 3 segundos.
     * 
     * @param idPedido El ID del pedido a confirmar.
     */
    private void scheduleOrderConfirmation(int idPedido) {
        scheduler.schedule(() -> {
            try {
                PedidoDTO pedidoConfirmado = procesarPedido(idPedido);
                System.out.println("Pedido confirmado: " + pedidoConfirmado);
            } catch (Exception e) {
                System.err.println("Error al confirmar el pedido: " + e.getMessage());
            }
        }, 3, TimeUnit.SECONDS); // 3 segundos de retraso
    }

    /**
     * Crea una orden de pedido y la guarda en la base de datos.
     * 
     * @param pedidoDTO El objeto que contiene la información del pedido a crear.
     * @return El pedido creado, representado por un {@code PedidoDTO}.
     * @throws Exception Si el cliente asociado al pedido no se encuentra.
     */
    public PedidoDTO crearOrden(PedidoDTO pedidoDTO) throws Exception {
        if (clienteService.obtenerCliente(pedidoDTO.getIdCliente()) == null) {
            throw new Exception("Cliente no encontrado");
        }

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdCliente(pedidoDTO.getIdCliente());
        pedidoEntity.setTotal(pedidoDTO.getTotal());
        pedidoEntity.setEstado("Pendiente");

        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        return MapperUtilities.mapearObjetos(pedidoGuardado, PedidoDTO.class);
    }

    /**
     * Procesa un pedido existente, cambiando su estado a "Confirmado".
     * 
     * @param idPedido El ID del pedido a procesar.
     * @return El pedido procesado, representado por un {@code PedidoDTO}.
     * @throws Exception Si el pedido no se encuentra o si el estado del pedido no es "Pendiente".
     */
    @Transactional
    public PedidoDTO procesarPedido(int idPedido) throws Exception {
        PedidoEntity pedidoEntity = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new Exception("Pedido no encontrado: " + idPedido));

        if (!pedidoEntity.getEstado().equals("Pendiente")) {
            throw new Exception("El pedido ya ha sido procesado o está en un estado incorrecto.");
        }

        pedidoEntity.setEstado("Confirmado");
        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        return MapperUtilities.mapearObjetos(pedidoGuardado, PedidoDTO.class);
    }
}
