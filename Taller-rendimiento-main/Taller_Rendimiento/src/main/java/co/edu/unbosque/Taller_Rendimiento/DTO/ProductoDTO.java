package co.edu.unbosque.Taller_Rendimiento.DTO;

/**
 * Clase que representa un producto en el sistema.
 * Esta clase se utiliza para almacenar y transferir información sobre un producto,
 * incluyendo detalles como el identificador del producto, el nombre, la descripción,
 * el stock disponible y el precio.
 */
public class ProductoDTO {
	private int idProducto, stock;
	private String nombre, descripcion;
	private float precio;

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	  /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code ProductoDTO} con el identificador del producto,
     * el nombre, la descripción, el stock disponible y el precio.
     *
     * @param idProducto   El identificador del producto.
     * @param nombre       El nombre del producto.
     * @param descripcion  La descripción del producto.
     * @param stock        El stock disponible del producto.
     * @param precio       El precio del producto.
     */
	public ProductoDTO(int idProducto, String nombre, String descripcion,int stock , float precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
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
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre del producto.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
	public String getDescripcion() {
		return descripcion;
	}

	 /**
     * Establece la descripción del producto.
     *
     * @param descripcion La descripción del producto.
     */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	 /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
	public float getPrecio() {
		return precio;
	}


    /**
     * Establece el precio del producto.
     *
     * @param precio El precio del producto.
     */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	  /**
     * Obtiene el stock disponible del producto.
     *
     * @return El stock disponible del producto.
     */
	public int getStock() {
		return stock;
	}

	 /**
     * Establece el stock disponible del producto.
     *
     * @param stock El stock disponible del producto.
     */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
