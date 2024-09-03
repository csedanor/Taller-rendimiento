package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.DTO.ProductoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoID;
import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.DetallePedidoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;
import jakarta.transaction.Transactional;

@Service
public class DetallePedidoService {
	
	@Autowired
	private DetallePedidoRepository detalleRepo;
	
	@Autowired
	private ProductoService productoService;
	
    @Transactional
    public DetallePedidoDTO agregarDetallePedido(int idPedido, DetallePedidoDTO detalleDTO) throws Exception {
        // Validar si el producto existe
        ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdPedido());


        // Validar el stock del producto
        int stockStatus = productoService.validarStock(detalleDTO.getId().getIdProducto(), detalleDTO.getCantidad());
        if (stockStatus != 1) {
            throw new Exception("Stock insuficiente o producto no encontrado.");
        }

        // Crear el ID compuesto
        DetallePedidoID detallePedidoID = new DetallePedidoID(detalleDTO.getId().getIdProducto(), idPedido);

        // Crear y guardar el detalle del pedido
        DetallePedidoEntity detalleEntity = new DetallePedidoEntity();
        detalleEntity.setId(detallePedidoID);
        detalleEntity.setCantidad(detalleDTO.getCantidad());
        detalleEntity.setToralizado(detalleDTO.getToralizado());

        DetallePedidoEntity detalleGuardado = detalleRepo.save(detalleEntity);

        // Actualizar el stock del producto
        productoService.actualizarStock(detalleDTO.getId().getIdProducto(), detalleDTO.getCantidad());

        // Mapear y devolver el DTO del detalle del pedido guardado
        DetallePedidoDTO detalleGuardadoDTO = MapperUtilities.mapearObjetos(detalleGuardado, DetallePedidoDTO.class);
        return detalleGuardadoDTO;
    }
}
