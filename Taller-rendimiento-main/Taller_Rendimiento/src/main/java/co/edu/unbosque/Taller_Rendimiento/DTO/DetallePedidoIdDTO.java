package co.edu.unbosque.Taller_Rendimiento.DTO;

/**
 * Clase que representa el identificador de un detalle de pedido.
 * Esta clase se utiliza para almacenar los identificadores de un producto
 * y un pedido específico.
 */

public class DetallePedidoIdDTO {
	
    private int idProducto;
    private int idPedido;

    /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code DetallePedidoIdDTO} sin valores asignados.
     */
	public DetallePedidoIdDTO() {
		// TODO Auto-generated constructor stub
	}


    /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code DetallePedidoIdDTO} con los valores proporcionados.
     *
     * @param idProducto El identificador del producto.
     * @param idPedido   El identificador del pedido.
     */
	public DetallePedidoIdDTO(int idProducto, int idPedido) {
		super();
		this.idProducto = idProducto;
		this.idPedido = idPedido;
	}

    /**
     * Obtiene el identificador del producto.
     *
     * @return El identificador del producto.
     */
	public int getIdProducto() {
		return idProducto;
	}

	/**
     * Establece el identificador del producto.
     *
     * @param idProducto El identificador del producto.
     */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	
	
	
	

}
