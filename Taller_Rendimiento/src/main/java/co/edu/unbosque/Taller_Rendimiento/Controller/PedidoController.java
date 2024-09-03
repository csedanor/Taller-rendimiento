package co.edu.unbosque.Taller_Rendimiento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.Service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    

//    @PostMapping("/crear")
//    public ResponseEntity<PedidoDTO> crearPedido(@RequestParam int idCliente, @RequestParam float total) {
//        PedidoDTO pedidoCreacionDTO = new PedidoDTO(idCliente, total);
//        try {
//            PedidoDTO pedidoDTO = pedidoService.crearPedido(pedidoCreacionDTO);
//            return new ResponseEntity<>(pedidoDTO, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PutMapping("/procesar/{idPedido}")
//    public ResponseEntity<PedidoDTO> procesarPedido(@PathVariable int idPedido) {
//        try {
//            PedidoDTO pedidoDTO = pedidoService.procesarPedido(idPedido);
//            return ResponseEntity.ok(pedidoDTO);
//        } catch (Exception e) {
//            return ResponseEntity.status(400).body(null); // Puedes ajustar el código de estado según el error
//        }
//    }
}
