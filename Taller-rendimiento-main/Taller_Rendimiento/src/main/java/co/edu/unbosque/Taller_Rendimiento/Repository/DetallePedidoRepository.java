package co.edu.unbosque.Taller_Rendimiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoID;


/**
 * Repositorio para gestionar las operaciones CRUD sobre la entidad {@code DetallePedidoEntity}.
 * Esta interfaz extiende {@code JpaRepository} y utiliza una clave primaria compuesta representada
 * por la clase {@code DetallePedidoID}.
 * La interfaz {@code DetallePedidoRepository} hereda todas las funcionalidades de {@code JpaRepository}, 
 * proporcionando métodos para realizar operaciones básicas de acceso a datos en la tabla {@code detalle_pedido}
 * de la base de datos. Dado que {@code DetallePedidoEntity} utiliza una clave primaria compuesta, 
 * {@code DetallePedidoID} se utiliza como el identificador de la entidad.
 */
public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, DetallePedidoID>{

}
