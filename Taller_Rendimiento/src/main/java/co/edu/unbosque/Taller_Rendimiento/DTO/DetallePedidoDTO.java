package co.edu.unbosque.Taller_Rendimiento.DTO;

public class DetallePedidoDTO {
	private int idProducto, idPedido, cantidad;
	private float toralizado;
	

	public DetallePedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	


	public DetallePedidoDTO(int idProducto, int idPedido, int cantidad, float toralizado) {
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
