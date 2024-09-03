package co.edu.unbosque.Taller_Rendimiento.DTO;

public class DetallePedidoIdDTO {
	
    private int idProducto;
    private int idPedido;

	public DetallePedidoIdDTO() {
		// TODO Auto-generated constructor stub
	}

	public DetallePedidoIdDTO(int idProducto, int idPedido) {
		super();
		this.idProducto = idProducto;
		this.idPedido = idPedido;
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
	
	
	
	

}
