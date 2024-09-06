package co.edu.unbosque.Taller_Rendimiento.DTO;

/**
 * Clase que representa un pedido en el sistema.
 * Esta clase se utiliza para almacenar y transferir información sobre un pedido,
 * incluyendo detalles como el identificador del pedido, el identificador del cliente,
 * el total del pedido, el estado y el número de tarjeta de pago.
 */
public class PedidoDTO {
	private int idPedido;
	private int idCliente;
	private float total;
	private String estado;
	private Long numeroTarjeta;

	 /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code PedidoDTO} con el estado por defecto "Pendiente".
     */ 

    public PedidoDTO() {
        this.estado = "Pendiente"; // Estado por defecto
    }
    
    public PedidoDTO(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code PedidoDTO} con el identificador del cliente,
     * el total del pedido y el estado por defecto "Pendiente".
     *
     * @param idCliente El identificador del cliente.
     * @param total     El total del pedido.
     */
    public PedidoDTO(int idCliente, float total) {
        this.idCliente = idCliente;
        this.total = total;
        this.estado = "Pendiente"; // Estado por defecto
    }

    /**
     * Constructor con todos los parámetros.
     * Inicializa un nuevo objeto {@code PedidoDTO} con el identificador del cliente,
     * el total del pedido, el estado por defecto "Pendiente" y el número de tarjeta.
     *
     * @param idCliente      El identificador del cliente.
     * @param total          El total del pedido.
     * @param estado         El estado del pedido.
     * @param numeroTarjeta  El número de tarjeta de pago.
     */
	public PedidoDTO(int idCliente, float total, String estado, Long numeroTarjeta) {
		super();
		this.idCliente = idCliente;
		this.total = total;
		this.estado = "Pendiente"; // Estado por defecto
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
     * Obtiene el total del pedido.
     *
     * @return El total del pedido.
     */
	public float getTotal() {
		return total;
	}


    /**
     * Establece el total del pedido.
     *
     * @param total El total del pedido.
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
     * @param estado El estado del pedido.
     */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	  /**
     * Obtiene el número de tarjeta de pago.
     *
     * @return El número de tarjeta de pago.
     */
	public Long getnumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
     * Establece el número de tarjeta de pago.
     *
     * @param numeroTarjeta El número de tarjeta de pago.
     */
	public void setnumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	

}
