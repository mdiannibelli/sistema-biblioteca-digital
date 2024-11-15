package bibliotecadigital.lists;

import java.time.LocalDate;

import bibliotecadigital.usuarios.Usuario;

public class Reseña {
	private Usuario usuario;
	private String descripcion;
	private double calificacion;
	private LocalDate fecha;
	
	public Reseña(Usuario usuario, String descripcion, double calificacion) {
		this.usuario = usuario; //TODO Receive only user ID
		this.descripcion = descripcion;
		this.calificacion = calificacion;
		this.fecha = LocalDate.now();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getUsuarioInfo() {
		return usuario.getNombre() + " " + usuario.getApellido();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
