package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.ProductoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.DetallePedidoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

@Service
public class DetallePedidoService {
	
	@Autowired
	private DetallePedidoRepository detalleRepo;
	
	@Autowired
	private ProductoService productoService;
	
    public DetallePedidoDTO crearDetalle(PedidoEntity pedido, DetallePedidoDTO detalleDTO) {
        
    	// Obtener producto y validar stock/existencia del mismo
        ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getIdProducto());
        int validacionStock = productoService.validarStock(detalleDTO.getIdProducto(), detalleDTO.getCantidad());
        
        // si no existe algún producto, o no hay el stock, que tire la transacción
        if (validacionStock != 1) {
            return null;
        }

        // Crear y guardar el detalle del pedido
        DetallePedidoEntity detalle = new DetallePedidoEntity();
        detalle.setIdPedido(pedido.getIdPedido());
        detalle.setIdProducto(producto.getIdProducto());
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setToralizado(producto.getPrecio() * detalleDTO.getCantidad());

        // Actualizar stock del producto
        productoService.actualizarStock(detalleDTO.getIdProducto(), detalleDTO.getCantidad());
        
        // Guardar el detalle instanciado
        detalleRepo.save(detalle);

        return MapperUtilities.mapearObjetos(detalle, DetallePedidoDTO.class);
    }



}
