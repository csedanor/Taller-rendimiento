package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa la entidad de un producto en la base de datos.
 * Esta clase está mapeada a la tabla {@code producto} y contiene la información sobre un producto disponible en el inventario.
 */
@Table(name="producto")
@Entity
public class ProductoEntity {
	@Id
	@Column(name="idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	@Column(name="nombre")
	private String nombre ;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="stock")
	private int stock;
	@Column(name="precio")
	private float precio;


    /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code ProductoEntity} sin valores asignados.
     */
	public ProductoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	   /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code ProductoEntity} con los valores proporcionados.
     *
     * @param idProducto   El identificador del producto.
     * @param nombre       El nombre del producto.
     * @param descripcion  La descripción del producto.
     * @param stock        La cantidad en stock del producto.
     * @param precio       El precio del producto.
     */
	public ProductoEntity(int idProducto, String nombre, String descripcion, int stock, float precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
     * Obtiene la cantidad en stock del producto.
     *
     * @return La cantidad en stock del producto.
     */
	public int getStock() {
		return stock;
	}

	/**
     * Establece la cantidad en stock del producto.
     *
     * @param stock La cantidad en stock del producto.
     */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
