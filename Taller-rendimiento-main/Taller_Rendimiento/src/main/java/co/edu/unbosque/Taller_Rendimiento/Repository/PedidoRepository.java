package co.edu.unbosque.Taller_Rendimiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;

/**
 * Repositorio para gestionar las operaciones CRUD sobre la entidad {@code PedidoEntity}.
 * Esta interfaz extiende {@code JpaRepository} y utiliza un identificador de tipo {@code Integer}.
 * La interfaz {@code PedidoRepository} proporciona métodos para realizar operaciones básicas de acceso a datos 
 * en la tabla {@code pedido} de la base de datos. Dado que {@code PedidoEntity} utiliza un identificador simple de 
 * tipo {@code Integer}, {@code PedidoRepository} se encarga de manejar las operaciones CRUD para esta entidad.
 */
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

}
