package co.edu.unbosque.Taller_Rendimiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.ProductoEntity;

/**
 * Repositorio para gestionar las operaciones CRUD sobre la entidad {@code ProductoEntity}.
 * Esta interfaz extiende {@code JpaRepository} y utiliza un identificador de tipo {@code Integer}.
 * La interfaz {@code ProductoRepository} proporciona métodos para realizar operaciones básicas de acceso a datos 
 * en la tabla {@code producto} de la base de datos. Dado que {@code ProductoEntity} utiliza un identificador simple de 
 * tipo {@code Integer}, {@code ProductoRepository} se encarga de manejar las operaciones CRUD para esta entidad.
 */
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
