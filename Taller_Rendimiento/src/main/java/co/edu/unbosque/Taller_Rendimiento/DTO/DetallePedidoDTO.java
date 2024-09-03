package co.edu.unbosque.Taller_Rendimiento.DTO;

public class DetallePedidoDTO {
	
	private DetallePedidoIdDTO id;
	private int cantidad;
	private float toralizado;
	

	public DetallePedidoDTO() {
		// TODO Auto-generated constructor stub
	}

	public DetallePedidoDTO(DetallePedidoIdDTO id, int cantidad, float toralizado) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.toralizado = toralizado;
	}
	
	
	public DetallePedidoIdDTO getId() {
		return id;
	}

	public void setId(DetallePedidoIdDTO id) {
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
