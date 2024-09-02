package co.edu.unbosque.Taller_Rendimiento.DTO;

public class PedidoDTO {
	private int idPedido, idCliente;
	private float total;
	private String estado;

	// Constructor por defecto
    public PedidoDTO() {
        this.estado = "Pendiente"; // Estado por defecto
    }

    // Constructor con parámetros
    public PedidoDTO(int idCliente, float total) {
        this.idCliente = idCliente;
        this.total = total;
        this.estado = "Pendiente"; // Estado por defecto
    }

    // Constructor completo (con idPedido incluido)
    public PedidoDTO(int idPedido, int idCliente, float total, String estado) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.total = total;
        this.estado = estado;
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
	

}
