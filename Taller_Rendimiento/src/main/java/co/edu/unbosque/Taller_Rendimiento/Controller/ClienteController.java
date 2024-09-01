package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.DTO.ClienteDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService cliente;
	
	// Ya esto devuelve la lista de los clientes, pero aún falta mappear
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = cliente.listCustom();
        return ResponseEntity.ok(clientes);
    }
    // Este método es para probar si sirve la conexión entre postman y la app
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
    
    



}
