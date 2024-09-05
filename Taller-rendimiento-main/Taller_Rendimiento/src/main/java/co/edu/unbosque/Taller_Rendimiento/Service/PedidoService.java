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

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoService detallePedidoService;
    private final ClienteService clienteService;
    private final ProductoService productoService;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, DetallePedidoService detallePedidoService,
                         ClienteService clienteService, ProductoService productoService) {
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoService = detallePedidoService;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @Transactional
    public PedidoDTO crearPedidoConDetalles(RequestOrderDTO requestOrderDTO) throws Exception {
        PedidoDTO pedidoDTO = requestOrderDTO.getPedidoDTO();
        List<DetallePedidoDTO> detallesDTO = requestOrderDTO.getDetalleDTO();

        // Validar existencia de productos y cantidades
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto());
            if (producto == null) {
                throw new Exception("El producto con ID " + detalleDTO.getId().getIdProducto() + " no existe.");
            }
            if (detalleDTO.getCantidad() <= 0) {
                throw new Exception("La cantidad para el producto con ID " + detalleDTO.getId().getIdProducto() + " debe ser mayor a 0.");
            }
        }

        // Crear y guardar el pedido para obtener el ID generado
        PedidoDTO pedidoCreado = crearOrden(pedidoDTO);
        int idPedido = pedidoCreado.getIdPedido();
        float total = 0;

        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto());
            detalleDTO.setToralizado(detalleDTO.getCantidad() * producto.getPrecio());
            DetallePedidoDTO detalleGuardadoDTO = detallePedidoService.agregarDetallePedido(idPedido, detalleDTO);
            total += detalleGuardadoDTO.getToralizado();
        }

        // Actualizar el total del pedido y el número de tarjeta
        pedidoCreado.setTotal(total);
        pedidoCreado.setnumeroTarjeta(pedidoDTO.getnumeroTarjeta());
        pedidoRepository.save(MapperUtilities.mapearObjetos(pedidoCreado, PedidoEntity.class));

        // Programar la confirmación del pedido
        scheduleOrderConfirmation(idPedido);

        return pedidoCreado;
    }

    // Método para confirmar un pedido después de un retraso
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
