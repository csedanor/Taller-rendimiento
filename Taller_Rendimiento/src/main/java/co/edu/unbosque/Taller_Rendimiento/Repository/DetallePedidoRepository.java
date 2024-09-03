package co.edu.unbosque.Taller_Rendimiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoEntity;
import co.edu.unbosque.Taller_Rendimiento.Entidades.DetallePedidoID;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, DetallePedidoID>{

}
