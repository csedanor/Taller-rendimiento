package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.Taller_Rendimiento.DTO.ProductoDTO;
import co.edu.unbosque.Taller_Rendimiento.Service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/verificar/{id}")
	public ResponseEntity<ProductoDTO>verificarExistencias(@PathVariable("id")Integer productoId ){
		ProductoDTO producto= productoService.obtenerProductoDTO(productoId);
		if(producto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/editarCantidad/{id}/{cantidad}")
	public ResponseEntity<?> actualizarStock(@PathVariable("id")Integer productoId, @PathVariable("cantidad")int cantidad){
		ProductoDTO producto= productoService.actualizarStock(productoId, cantidad);
		if(producto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado o no hay stock");
		}
		return ResponseEntity.ok(producto);
	}

}
