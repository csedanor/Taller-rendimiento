package co.edu.unbosque.Taller_Rendimiento.DTO;

/**
 * Clase que representa un Cliente en el sistema.
 *
 * Esta clase contiene la información básica del cliente, incluyendo su identificador, nombre, teléfono,
 * correo electrónico y dirección.
 *
 */
public class ClienteDTO {
	
	private int idCliente;
	private String nombre,telefono, correo, direccion; 
	
	/**
     * Constructor por defecto.
     * 
     * Inicializa un nuevo objeto {@code ClienteDTO} sin valores asignados.
     
     */

	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	 /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code ClienteDTO} con los valores proporcionados.
     *
     * @param idCliente   El identificador del cliente.
     * @param nombre      El nombre del cliente.
     * @param telefono    El número de teléfono del cliente.
     * @param correo      La dirección de correo electrónico del cliente.
     * @param direccion   La dirección física del cliente.
     */
	
	public ClienteDTO(int idCliente, String nombre, String telefono, String correo, String direccion) {
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
     * Obtiene la dirección de correo electrónico del cliente.
     *
     * @return La dirección de correo electrónico del cliente.
     */ 
	
	public String getCorreo() {
		return correo;
	}
	
	 /**
     * Establece la dirección de correo electrónico del cliente.
     *
     * @param correo La dirección de correo electrónico del cliente.
     */

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
    /**
     * Obtiene la dirección física del cliente.
     *
     * @return La dirección física del cliente.
     */

	public String getDireccion() {
		return direccion;
	}

	  /**
     * Establece la dirección física del cliente.
     *
     * @param direccion La dirección física del cliente.
     */
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
