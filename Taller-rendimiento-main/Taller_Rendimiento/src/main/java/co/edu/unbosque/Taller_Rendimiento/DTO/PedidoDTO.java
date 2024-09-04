package co.edu.unbosque.Taller_Rendimiento.DTO;

public class PedidoDTO {
	private int idPedido;
	private int idCliente;
	private float total;
	private String estado;
	private Long numeroTarjeta;

	// Constructor por defecto
    public PedidoDTO() {
        this.estado = "Pendiente"; // Estado por defecto
    }
    
    public PedidoDTO(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

	// Constructor con parámetros
    public PedidoDTO(int idCliente, float total) {
        this.idCliente = idCliente;
        this.total = total;
        this.estado = "Pendiente"; // Estado por defecto
    }


	public PedidoDTO(int idCliente, float total, String estado, Long numeroTarjeta) {
		super();
		this.idCliente = idCliente;
		this.total = total;
		this.estado = "Pendiente"; // Estado por defecto
		this.numeroTarjeta = numeroTarjeta;
	}


	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getnumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setnumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	

}
