package co.edu.unbosque.Taller_Rendimiento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.RequestOrderDTO;
import co.edu.unbosque.Taller_Rendimiento.Service.PedidoService;
import co.edu.unbosque.Taller_Rendimiento.Service.TarjetaService;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private TarjetaService tarjetaService;
    
    

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedidoConDetalles(@RequestBody RequestOrderDTO requestOrderDTO, @RequestBody Long tarjeta) {
    	try {
            // Validar tarjeta antes de proceder
            if (requestOrderDTO.getTarjetaDTO() != null) {
                boolean tarjetaValida = tarjetaService.validarTarjeta(requestOrderDTO.getTarjetaDTO().getNumero());
                if (!tarjetaValida) {
                    return new ResponseEntity<>("Número de tarjeta inválido", HttpStatus.BAD_REQUEST);
                }
            }
        	pedidoService.crearOrden(requestOrderDTO.getPedidoDTO());
            pedidoService.crearPedidoConDetalles(requestOrderDTO);
            
            return new ResponseEntity<>("Pedido creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el pedido: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
