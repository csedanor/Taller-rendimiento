package co.edu.unbosque.Taller_Rendimiento.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public PedidoDTO crearPedido(PedidoDTO pedidoCreacionDTO) throws Exception {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdCliente(pedidoCreacionDTO.getIdCliente());
        pedidoEntity.setTotal(pedidoCreacionDTO.getTotal());
        pedidoEntity.setEstado("Pendiente"); // Estado predeterminado

        PedidoEntity pedidoGuardado = pedidoRepository.save(pedidoEntity);

        PedidoDTO pedidoGuardadoDTO = new PedidoDTO();
        pedidoGuardadoDTO.setIdPedido(pedidoGuardado.getIdPedido()); // El ID es auto-generado
        pedidoGuardadoDTO.setIdCliente(pedidoGuardado.getIdCliente());
        pedidoGuardadoDTO.setTotal(pedidoGuardado.getTotal());
        pedidoGuardadoDTO.setEstado(pedidoGuardado.getEstado());

        return pedidoGuardadoDTO;
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

        PedidoDTO pedidoGuardadoDTO = new PedidoDTO();
        pedidoGuardadoDTO.setIdPedido(pedidoGuardado.getIdPedido());
        pedidoGuardadoDTO.setIdCliente(pedidoGuardado.getIdCliente());
        pedidoGuardadoDTO.setTotal(pedidoGuardado.getTotal());
        pedidoGuardadoDTO.setEstado(pedidoGuardado.getEstado());

        return pedidoGuardadoDTO;
    }
}
