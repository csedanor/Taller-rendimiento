package co.edu.unbosque.Taller_Rendimiento.Repository;

/**
 * Repositorio para gestionar las operaciones CRUD sobre la entidad {@code ClienteEntity}.
 * Esta interfaz extiende {@code JpaRepository}, proporcionando métodos para realizar operaciones básicas
 * de acceso a datos en la tabla {@code cliente} de la base de datos.
 * La interfaz {@code ClienteRepository} hereda todas las funcionalidades de {@code JpaRepository}, que incluye
 * métodos como {@code save()}, {@code findById()}, {@code findAll()}, {@code deleteById()}, entre otros.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
