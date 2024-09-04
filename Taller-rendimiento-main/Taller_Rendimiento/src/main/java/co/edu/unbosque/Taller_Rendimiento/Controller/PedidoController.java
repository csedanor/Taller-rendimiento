package co.edu.unbosque.Taller_Rendimiento.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoIdDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.PedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.RequestOrderDTO;
import co.edu.unbosque.Taller_Rendimiento.Service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @PostMapping("/procesar")
    public ResponseEntity<?> crearPedidoConDetalles(
            @RequestParam int idCliente,
            @RequestParam Long numeroTarjeta,
            @RequestParam List<Integer> idProductos,
            @RequestParam List<Integer> cantidades) {
        try {
            PedidoDTO pedidoDTO = new PedidoDTO(idCliente, 0);
            pedidoDTO.setnumeroTarjeta(numeroTarjeta);
            RequestOrderDTO requestOrderDTO = new RequestOrderDTO(pedidoDTO, idProductos.stream()
                    .map(id -> new DetallePedidoDTO(new DetallePedidoIdDTO(id, 0), 1, 0))
                    .toList());

            PedidoDTO pedidoCreado = pedidoService.crearPedidoConDetalles(requestOrderDTO);

            Map<String, Object> response = new HashMap<>();
            response.put("idCliente", pedidoCreado.getIdCliente());
            response.put("total", pedidoCreado.getTotal());
            response.put("idPedido", pedidoCreado.getIdPedido());
            response.put("mensaje", "Tarjeta aceptada");
            response.put("mensaje", "Pedido confirmado");

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // En caso de error, cancelar el pedido y devolver un mensaje adecuado
            return new ResponseEntity<>(Map.of(
                    "mensaje", "Pedido cancelado: " + e.getMessage(),
                    "estado", "Cancelado"
            ), HttpStatus.BAD_REQUEST);
        }
    }


}
