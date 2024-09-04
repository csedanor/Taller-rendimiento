package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Table(name = "detalle_pedido")
@Entity
public class DetallePedidoEntity {

    @EmbeddedId
    private DetallePedidoID id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "valor_total")
    private float toralizado;

    public DetallePedidoEntity() {}

    public DetallePedidoEntity(DetallePedidoID id, int cantidad, float toralizado) {
        this.id = id;
        this.cantidad = cantidad;
        this.toralizado = toralizado;
    }


    public DetallePedidoID getId() {
        return id;
    }

    public void setId(DetallePedidoID id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getToralizado() {
        return toralizado;
    }

    public void setToralizado(float toralizado) {
        this.toralizado = toralizado;
    }
	

}
