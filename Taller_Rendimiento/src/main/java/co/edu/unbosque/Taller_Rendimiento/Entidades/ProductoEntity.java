package co.edu.unbosque.Taller_Rendimiento.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	@Column(name="precio")
	private float precio;

	public ProductoEntity() {
		// TODO Auto-generated constructor stub
	}
	

	public ProductoEntity(int idProducto, String nombre, String descripcion, float precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
