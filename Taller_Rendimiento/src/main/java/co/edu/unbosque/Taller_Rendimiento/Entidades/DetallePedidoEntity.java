package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="detalle_pedido")
@Entity
public class DetallePedidoEntity {
	
	@Id
	@Column(name="producto_idproducto")
	private int idProducto;
	@Id
	@Column(name="pedido_idpedido")
	private int idPedido;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="valor_total")
	private float toralizado;
	

	public DetallePedidoEntity() {
		// TODO Auto-generated constructor stub
	}
	


	public DetallePedidoEntity(int idProducto, int idPedido, int cantidad, float toralizado) {
		super();
		this.idProducto = idProducto;
		this.idPedido = idPedido;
		this.cantidad = cantidad;
		this.toralizado = toralizado;
	}



	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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
