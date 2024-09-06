package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Clase que representa una entidad de detalle de pedido en la base de datos.
 * Mapea la tabla "detalle_pedido" en la base de datos a la clase {@code DetallePedidoEntity}.
 */
@Table(name = "detalle_pedido")
@Entity
public class DetallePedidoEntity {

    @EmbeddedId
    private DetallePedidoID id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "valor_total")
    private float toralizado;
    
    /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code DetallePedidoEntity} sin valores asignados.
     */
    public DetallePedidoEntity() {}

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code DetallePedidoEntity} con los valores proporcionados.
     *
     * @param id          El identificador del detalle de pedido, compuesto por {@code DetallePedidoID}.
     * @param cantidad    La cantidad del producto en el detalle del pedido.
     * @param toralizado  El valor total del detalle del pedido.
     */
    public DetallePedidoEntity(DetallePedidoID id, int cantidad, float toralizado) {
        this.id = id;
        this.cantidad = cantidad;
        this.toralizado = toralizado;
    }

    /**
     * Obtiene el identificador del detalle del pedido.
     *
     * @return El identificador del detalle del pedido.
     */
    public DetallePedidoID getId() {
        return id;
    }

    /**
     * Establece el identificador del detalle del pedido.
     *
     * @param id El identificador del detalle del pedido.
     */
    public void setId(DetallePedidoID id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad del producto en el detalle del pedido.
     *
     * @return La cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto en el detalle del pedido.
     *
     * @param cantidad La cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el valor total del detalle del pedido.
     *
     * @return El valor total del detalle del pedido.
     */
    public float getToralizado() {
        return toralizado;
    }

    /**
     * Establece el valor total del detalle del pedido.
     *
     * @param toralizado El valor total del detalle del pedido.
     */
    public void setToralizado(float toralizado) {
        this.toralizado = toralizado;
    }
	

}
