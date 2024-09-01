package co.edu.unbosque.Taller_Rendimiento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.Service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired 
	private PedidoService pedidoService;

    // Este método es para probar si sirve la conexión entre postman y la app
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
    
    

}
