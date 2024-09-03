package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class DetallePedidoID {
    
    @Column(name = "producto_idproducto")
    private int idProducto;

    @Column(name = "pedido_idpedido")
    private int idPedido;


    public DetallePedidoID() {}

    public DetallePedidoID(int idProducto, int idPedido) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
    }

    // Getters y Setters

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
