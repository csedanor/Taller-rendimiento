package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


/**
 * Clase que representa una clave compuesta para la entidad de detalle de pedido.
 * Esta clase se utiliza como identificador embebido para {@code DetallePedidoEntity}.
 */
@Embeddable
public class DetallePedidoID {
    
    @Column(name = "producto_idproducto")
    private int idProducto;

    @Column(name = "pedido_idpedido")
    private int idPedido;

    /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code DetallePedidoID} sin valores asignados.
     */
    public DetallePedidoID() {}

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code DetallePedidoID} con los valores proporcionados.
     *
     * @param idProducto El identificador del producto en el detalle del pedido.
     * @param idPedido   El identificador del pedido en el detalle del pedido.
     */
    public DetallePedidoID(int idProducto, int idPedido) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el identificador del pedido.
     *
     * @return El identificador del pedido.
     */
    public int getIdPedido() {
        return idPedido;
    }
    
    /**
     * Establece el identificador del pedido.
     *
     * @param idPedido El identificador del pedido.
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return El identificador del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param idProducto El identificador del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
