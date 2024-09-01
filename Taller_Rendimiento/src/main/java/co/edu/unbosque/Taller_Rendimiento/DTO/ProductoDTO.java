package co.edu.unbosque.Taller_Rendimiento.DTO;

public class ProductoDTO {
	private int idProducto;
	private String nombre, descripcion;
	private float precio;

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ProductoDTO(int idProducto, String nombre, String descripcion, float precio) {
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
