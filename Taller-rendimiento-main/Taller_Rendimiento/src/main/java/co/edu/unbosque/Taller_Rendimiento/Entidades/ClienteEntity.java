package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa una entidad de cliente en la base de datos.
 * Mapea la tabla "cliente" en la base de datos a la clase {@code ClienteEntity}.
 */
@Table(name="cliente")
@Entity
public class ClienteEntity {
	
	@Id
	@Column(name="idcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	@Column(name="nombre")
	private String nombre;
	@Column(name="telefono")
	private String  telefono;
	@Column(name="correo")
	private String correo; 
	
	@Column(name="direccion")
	private String direccion; 
	
	   /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code ClienteEntity} sin valores asignados.
     */
	public ClienteEntity() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code ClienteEntity} con los valores proporcionados.
     *
     * @param idCliente  El identificador del cliente.
     * @param nombre     El nombre del cliente.
     * @param telefono   El número de teléfono del cliente.
     * @param correo     El correo electrónico del cliente.
     * @param direccion  La dirección del cliente.
     */
	public ClienteEntity(int idCliente, String nombre, String telefono, String correo, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
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
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
	public String getNombre() {
		return nombre;
	}

	 /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre del cliente.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El número de teléfono del cliente.
     */
	public String getTelefono() {
		return telefono;
	}

	  /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El número de teléfono del cliente.
     */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return El correo electrónico del cliente.
     */
	public String getCorreo() {
		return correo;
	}

	   /**
     * Establece el correo electrónico del cliente.
     *
     * @param correo El correo electrónico del cliente.
     */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	 /**
     * Obtiene la dirección del cliente.
     *
     * @return La dirección del cliente.
     */
	public String getDireccion() {
		return direccion;
	}

	   /**
     * Establece la dirección del cliente.
     *
     * @param direccion La dirección del cliente.
     */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
