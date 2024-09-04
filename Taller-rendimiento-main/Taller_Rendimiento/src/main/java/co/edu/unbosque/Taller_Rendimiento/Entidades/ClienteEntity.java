package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	

	public ClienteEntity() {
		// TODO Auto-generated constructor stub
	}

	public ClienteEntity(int idCliente, String nombre, String telefono, String correo, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
