package co.edu.unbosque.Taller_Rendimiento.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unbosque.Taller_Rendimiento.DTO.DetallePedidoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoID;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.DetallePedidoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

@Service
public class DetallePedidoService {

    private final DetallePedidoRepository detalleRepo;
    private final ProductoService productoService;

    @Autowired
    public DetallePedidoService(DetallePedidoRepository detalleRepo, ProductoService productoService) {
        this.detalleRepo = detalleRepo;
        this.productoService = productoService;
    }

    @Transactional
    public DetallePedidoDTO agregarDetallePedido(int idPedido, DetallePedidoDTO detalleDTO) throws Exception {
        ProductoEntity producto = productoService.obtenerProductoEntity(detalleDTO.getId().getIdProducto());
        if (producto == null || !productoService.validarStock(detalleDTO.getId().getIdProducto(), detalleDTO.getCantidad())) {
            throw new Exception("Stock insuficiente o producto no encontrado.");
        }

        DetallePedidoID detallePedidoID = new DetallePedidoID(detalleDTO.getId().getIdProducto(), idPedido);
        DetallePedidoEntity detalleEntity = new DetallePedidoEntity();
        detalleEntity.setId(detallePedidoID);
        detalleEntity.setCantidad(detalleDTO.getCantidad());
        detalleEntity.setToralizado(detalleDTO.getToralizado());

        DetallePedidoEntity detalleGuardado = detalleRepo.save(detalleEntity);
        productoService.actualizarStock(detalleDTO.getId().getIdProducto(), detalleDTO.getCantidad());

        return MapperUtilities.mapearObjetos(detalleGuardado, DetallePedidoDTO.class);
    }
}
