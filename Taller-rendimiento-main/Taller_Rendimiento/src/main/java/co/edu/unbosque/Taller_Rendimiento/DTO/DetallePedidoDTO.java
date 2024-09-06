package co.edu.unbosque.Taller_Rendimiento.DTO;

/**
 * Clase que representa un detalle de pedido en el sistema.
 * Esta clase contiene información sobre un artículo en un pedido específico,
 * incluyendo su identificador, cantidad y el valor totalizado.
 */

public class DetallePedidoDTO {
	
	private DetallePedidoIdDTO id;
	private int cantidad;
	private float toralizado;

	 /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code DetallePedidoDTO} sin valores asignados.
     * Inicializa el identificador {@code id} como una nueva instancia de {@code DetallePedidoIdDTO}.
     */

	public DetallePedidoDTO() {
        this.id = new DetallePedidoIdDTO(); // Inicializar id
    }
	
	/**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code DetallePedidoDTO} con los valores proporcionados.
     *
     * @param id         El identificador del detalle del pedido, representado por {@code DetallePedidoIdDTO}.
     * @param cantidad   La cantidad del artículo en el pedido.
     * @param toralizado El valor totalizado del artículo en el pedido.
     */

	public DetallePedidoDTO(DetallePedidoIdDTO id, int cantidad, float toralizado) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.toralizado = toralizado;
	}
	
    /**
     * Obtiene el identificador del detalle del pedido.
     *
     * @return El identificador del detalle del pedido, representado por {@code DetallePedidoIdDTO}.
     */ 
	public DetallePedidoIdDTO getId() {
		return id;
	}
	
	/**
     * Establece el identificador del detalle del pedido.
     *
     * @param id El identificador del detalle del pedido, representado por {@code DetallePedidoIdDTO}.
     */
	public void setId(DetallePedidoIdDTO id) {
		this.id = id;
	}
  
	 /**
     * Obtiene la cantidad del artículo en el pedido.
     *
     * @return La cantidad del artículo en el pedido.
     */
	public int getCantidad() {
		return cantidad;
	}

	 /**
     * Establece la cantidad del artículo en el pedido.
     *
     * @param cantidad La cantidad del artículo en el pedido.
     */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
     * Obtiene el valor totalizado del artículo en el pedido.
     *
     * @return El valor totalizado del artículo en el pedido.
     */
	public float getToralizado() {
		return toralizado;
	}
	
	/**
     * Establece el valor totalizado del artículo en el pedido.
     *
     * @param toralizado El valor totalizado del artículo en el pedido.
     */
	public void setToralizado(float toralizado) {
		this.toralizado = toralizado;
	}
	

}
