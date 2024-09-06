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

/**
 * Servicio para gestionar las operaciones relacionadas con los detalles de pedidos en la entidad 
 * {@code DetallePedidoEntity}. Utiliza {@code DetallePedidoRepository} para las operaciones de acceso 
 * a datos y {@code ProductoService} para manejar la lógica de negocio relacionada con productos.
 * El servicio está anotado con {@code @Service} y maneja transacciones con {@code @Transactional}.
 */
@Service
public class DetallePedidoService {

    private final DetallePedidoRepository detalleRepo;
    private final ProductoService productoService;

    /**
     * Constructor de {@code DetallePedidoService}.
     * 
     * @param detalleRepo El repositorio de detalles de pedido a ser utilizado por el servicio.
     * @param productoService El servicio de productos a ser utilizado por el servicio.
     */
    @Autowired
    public DetallePedidoService(DetallePedidoRepository detalleRepo, ProductoService productoService) {
        this.detalleRepo = detalleRepo;
        this.productoService = productoService;
    }

    /**
     * Agrega un detalle de pedido a la base de datos. Verifica si el producto existe y si hay suficiente 
     * stock disponible antes de guardar el detalle del pedido. Actualiza el stock del producto después 
     * de guardar el detalle del pedido.
     *
     * La operación es transaccional para garantizar la consistencia de los datos en caso de fallos.
     * 
     * @param idPedido El ID del pedido al que se agregará el detalle.
     * @param detalleDTO El detalle del pedido que se agregará, representado por un {@code DetallePedidoDTO}.
     * @return El detalle del pedido guardado, mapeado a {@code DetallePedidoDTO}.
     * @throws Exception Si el producto no se encuentra o si el stock es insuficiente.
     */
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
