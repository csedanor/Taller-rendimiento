package co.edu.unbosque.Taller_Rendimiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

}
