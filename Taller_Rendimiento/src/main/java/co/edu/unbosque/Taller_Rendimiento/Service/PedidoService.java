package co.edu.unbosque.Taller_Rendimiento.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private DetallePedidoService detallePedidoService;

    public void procesarPedido(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detallesDTO) {
        // Convertir PedidoDTO a PedidoEntity
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdCliente(pedidoDTO.getIdCliente());
        pedidoEntity.setTotal(pedidoDTO.getTotal());
        pedidoEntity.setEstado(pedidoDTO.getEstado());
        // Guardar el pedido en la base de datos
        PedidoEntity pedidoGuardado = pedidoRepo.save(pedidoEntity);
        // Procesar y guardar cada detalle del pedido
        for (DetallePedidoDTO detalleDTO : detallesDTO) {
            detallePedidoService.crearDetalle(pedidoGuardado, detalleDTO);
        }
    }
}
