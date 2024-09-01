package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        
    	//Agegar el método que se vaya a usar para la inserción de pedido, teniendo en cuenta el detalle pedido
    	
        return ResponseEntity.ok("Hola Q ace");
    }


    
    

}
