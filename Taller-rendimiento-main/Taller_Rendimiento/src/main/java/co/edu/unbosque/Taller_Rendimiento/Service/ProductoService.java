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
    

    public ProductoEntity obtenerProductoEntity(int idProducto) throws Exception {
        return productoRepo.findById(idProducto)
            .orElseThrow(() -> new Exception("Producto no encontrado"));
    }

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
        if (producto == null || producto.getStock() < cantidad) {
            return false; // No hay stock o no existe la 
        }
        return true; // Hay stock y existe el producto
    }


    public ProductoDTO actualizarStock(Integer productoId, int cantidad) {
        ProductoEntity producto = obtenerProductoEntity(productoId);
        producto.setStock(producto.getStock() - cantidad);
        productoRepo.save(producto);
        return MapperUtilities.mapearObjetos(producto, ProductoDTO.class);
    }
    
    public int obtenerTotal() {
    	
    	
		return 0;
    	
    }
    
}

