package co.edu.unbosque.Taller_Rendimiento.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.RequestOrderDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.PedidoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;
import jakarta.transaction.Transactional;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoService detallePedidoService;
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;
    
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public PedidoDTO crearPedidoConDetalles(RequestOrderDTO requestOrderDTO) throws Exception {
        PedidoDTO pedidoDTO = requestOrderDTO.getPedidoDTO();
        List<DetallePedidoDTO> detallesDTO = requestOrderDTO.getDetalleDTO();
        
        // Validar existencia de productos y cantidades
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            if (productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto()) == null) {
                // Producto no existe
                throw new Exception("El producto con ID " + detalleDTO.getId().getIdProducto() + " no existe.");
            }
            if (detalleDTO.getCantidad() <= 0) {
                // Cantidad no válida
                throw new Exception("La cantidad para el producto con ID " + detalleDTO.getId().getIdProducto() + " debe ser mayor a 0.");
            }
        }

        // Crear y guardar el pedido para obtener el ID generado
        PedidoDTO pedidoCreado = crearOrden(pedidoDTO);
        int idPedido = pedidoCreado.getIdPedido();
        float total = 0;
        
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            detalleDTO.setToralizado(detalleDTO.getCantidad() * productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto()).getPrecio());
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
                // Lógica para mostrar el pedido confirmado en la respuesta si es necesario
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
