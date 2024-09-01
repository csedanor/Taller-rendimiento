package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.DTO.ClienteDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	// Ya esto devuelve la lista de los clientes, pero aún falta mappear
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listCustom();
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/obtenerCliente/{id}")
    public ResponseEntity<?> listCustom(@PathVariable("id")Integer clienteID){
    	ClienteDTO cliente = clienteService.obtenerCliente(clienteID);
		if(cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
		}
        return ResponseEntity.ok(cliente);
    }

}
