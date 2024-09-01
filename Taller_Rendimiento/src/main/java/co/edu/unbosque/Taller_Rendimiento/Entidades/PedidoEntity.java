package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="pedido")
@Entity
public class PedidoEntity {
	
	@Id
	@Column(name="idpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	@Column(name="cliente_idcliente")
	private int idCliente;
	@Column(name="total")
	private float total;
	@Column(name="estado")
	private String estado;

	public PedidoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PedidoEntity(int idPedido, int idCliente, float total, String estado) {
		super();
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
