package co.edu.unbosque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Entidades.ClienteEntity;
import co.edu.unbosque.Service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService cliente;

	public ClienteController() {
		// TODO Auto-generated constructor stub
	}
	
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteEntity>> listarClientes() {
        List<ClienteEntity> clientes = cliente.listCustom();
        return ResponseEntity.ok(clientes);
    }


}
