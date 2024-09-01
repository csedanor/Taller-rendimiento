package co.edu.unbosque.Taller_Rendimiento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.Service.DetallePedidoService;

@RestController
@RequestMapping("/detalle")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoService detalleService;


}
