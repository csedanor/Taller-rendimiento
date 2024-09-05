package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.Optional;

import co.edu.unbosque.Taller_Rendimiento.DTO.ProductoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ProductoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepo;

    @Autowired
    public ProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Cacheable(value = "productos", key = "#productoId")
    public ProductoEntity obtenerProductoEntity(Integer productoId) {
        return productoRepo.findById(productoId).orElse(null);
    }

    public ProductoDTO obtenerProductoDTO(Integer productoId) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        if (producto == null) {
            return null;
        }
        return MapperUtilities.mapearObjetos(producto, ProductoDTO.class);
    }

    public boolean validarStock(Integer productoId, int cantidad) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        return producto != null && producto.getStock() >= cantidad;
    }

    @Transactional
    public ProductoDTO actualizarStock(Integer productoId, int cantidad) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        if (producto != null) {
            producto.setStock(producto.getStock() - cantidad);
            productoRepo.save(producto);
            return MapperUtilities.mapearObjetos(producto, ProductoDTO.class);
        }
        return null;
    }

    public int obtenerTotal() {
        return 0;
    }
}
