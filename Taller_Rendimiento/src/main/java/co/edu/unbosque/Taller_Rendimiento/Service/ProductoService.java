package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.DTO.ProductoDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ProductoRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

@Service
public class ProductoService {
	
    @Autowired
    private ProductoRepository productoRepo;

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

    public int validarStock(Integer productoId, int cantidad) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        if (producto == null) {
            return -1; // on existe el producto
        }
        if (producto.getStock() < cantidad) {
            return 0; //no hay stock  
        }
        return 1; // Hay stock y existe el producto
    }


    public ProductoDTO actualizarStock(Integer productoId, int cantidad) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        int stock = validarStock(productoId, cantidad);
        
        if (stock != 1) {
            return null; 
        }
        producto.setStock(producto.getStock() - cantidad);
        productoRepo.save(producto);
        return MapperUtilities.mapearObjetos(producto, ProductoDTO.class);
    }
    
}

