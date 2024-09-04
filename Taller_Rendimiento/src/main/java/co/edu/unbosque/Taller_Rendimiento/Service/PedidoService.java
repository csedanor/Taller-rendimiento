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

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoService detallePedidoService;
    
    @Autowired
    private ClienteService clienteService;

    
    public void crearPedidoConDetalles(RequestOrderDTO requestOrderDTO) throws Exception {
        int idPedido = requestOrderDTO.getPedidoDTO().getIdPedido();

        float total = 0 ;
        // Procesar detalles del pedido
        List<DetallePedidoDTO> detallesDTO = requestOrderDTO.getDetalleDTO();
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            detallePedidoService.agregarDetallePedido(idPedido, detalleDTO);
        }
        // no sé como hacer que sumen los totales
        //requestOrderDTO.getPedidoDTO().setTotal(total);

        //return total;
    }
    
    
    public PedidoDTO crearOrden(PedidoDTO pedidoDTO) throws Exception {
        // Validar si el cliente existe
        if (clienteService.obtenerCliente(pedidoDTO.getIdCliente()) == null) {
            throw new Exception("Cliente no encontrado");
        }

        // Crear y guardar el pedido
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdCliente(pedidoDTO.getIdCliente());
        pedidoEntity.setTotal(pedidoDTO.getTotal());
        pedidoEntity.setEstado("Pendiente"); // Estado predeterminado

        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        // Mapear y devolver el DTO del pedido guardado
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
        
        // Cuando cambie el estado, que guarde
        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        // Mapear y devolver el DTO del pedido guardado
        PedidoDTO pedidoGuardadoDTO = MapperUtilities.mapearObjetos(pedidoGuardado, PedidoDTO.class);
        return pedidoGuardadoDTO;
    }
    
    // detallePedidoEntity.setValorTotal(producto.getPrecio() * detallePedidoDTO.getCantidad());
}
