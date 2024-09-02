package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.Service.PedidoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired 
    private PedidoService pedidoService;

    @PostMapping("/procesar")
    public ResponseEntity<?> procesarPedido(@RequestBody PedidoDTO pedidoDTO, @RequestBody List<DetallePedidoDTO> detallesDTO) {
        try {
            // Llamar al servicio para procesar el pedido y sus detalles
            pedidoService.procesarPedido(pedidoDTO, detallesDTO);
            // Responder con un mensaje de éxito o de error
            return ResponseEntity.ok("Pedido procesado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al procesar el pedido: " + e.getMessage());
        }
    }
}
