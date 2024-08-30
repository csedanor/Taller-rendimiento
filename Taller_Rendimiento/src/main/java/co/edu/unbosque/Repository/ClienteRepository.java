package co.edu.unbosque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Entidades.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
