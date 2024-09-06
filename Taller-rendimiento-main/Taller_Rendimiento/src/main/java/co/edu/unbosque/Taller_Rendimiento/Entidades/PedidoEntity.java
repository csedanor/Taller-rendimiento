package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa la entidad de un pedido en la base de datos.
 * Esta clase está mapeada a la tabla {@code pedido} y contiene la información sobre un pedido realizado por un cliente.
 */
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
	@Column(name="NumeroTarjeta")
	private Long numeroTarjeta;

	  /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code PedidoEntity} sin valores asignados.
     */
	public PedidoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	 /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code PedidoEntity} con los valores proporcionados.
     *
     * @param idPedido       El identificador del pedido.
     * @param idCliente      El identificador del cliente que realizó el pedido.
     * @param total          El valor total del pedido.
     * @param estado         El estado del pedido (por ejemplo, "Pendiente", "Completado").
     * @param numeroTarjeta  El número de tarjeta utilizado en el pedido.
     */
	public PedidoEntity(int idPedido, int idCliente, float total, String estado, Long numeroTarjeta) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.total = total;
		this.estado = estado;
		this.numeroTarjeta = numeroTarjeta;
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
     * Obtiene el identificador del cliente.
     *
     * @return El identificador del cliente.
     */
	public int getIdCliente() {
		return idCliente;
	}

	/**
     * Establece el identificador del cliente.
     *
     * @param idCliente El identificador del cliente.
     */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	  /**
     * Obtiene el valor total del pedido.
     *
     * @return El valor total del pedido.
     */
	public float getTotal() {
		return total;
	}

	/**
     * Establece el valor total del pedido.
     *
     * @param total El valor total del pedido.
     */
	public void setTotal(float total) {
		this.total = total;
	}

	 /**
     * Obtiene el estado del pedido.
     *
     * @return El estado del pedido.
     */
	public String getEstado() {
		return estado;
	}


    /**
     * Establece el estado del pedido.
     *
     * @param estado El estado del pedido (por ejemplo, "Pendiente", "Completado").
     */
	public void setEstado(String estado) {
		this.estado = estado;
	}

    /**
     * Obtiene el número de tarjeta utilizado en el pedido.
     *
     * @return El número de tarjeta.
     */
	public Long getnumeroTarjeta() {
		return numeroTarjeta;
	}

    /**
     * Establece el número de tarjeta utilizado en el pedido.
     *
     * @param numeroTarjeta El número de tarjeta.
     */
	public void setnumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	
	

}
