package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.lists.Reseña;

public abstract class RecursoMultimedia {
	protected UUID id;
	protected String titulo;
	protected List<Autor> autores;
	protected LocalDate fecha_publicacion;
	protected Genero genero;
	protected EstadoRecurso estado;
	protected double rate_promedio;
	protected List<Reseña> reseñas;
	
	public RecursoMultimedia(String titulo, List<Autor> autores, LocalDate fecha_publicacion, Genero genero, EstadoRecurso estado, double rate_promedio, List<Reseña> reseñas) {
		this.id = UUID.randomUUID();
		this.titulo = titulo;
		this.autores = autores != null ? autores : new ArrayList<>();
		this.fecha_publicacion = fecha_publicacion != null ? fecha_publicacion : LocalDate.now();
		this.estado = estado != null ? estado : estado.DISPONIBLE;
		this.rate_promedio = rate_promedio;
		this.reseñas = reseñas != null ? reseñas : new ArrayList<>();
	}
	
	public void mostrarInfo() {
		System.out.println("Recurso " + id);
		System.out.println("Nombre del recurso: " + titulo);
		System.out.println("Autores: " + (autores.size() == 0 ? "No hay autores" : ""));
		for(Autor autor : autores) {
			System.out.println(autor.getNombre() + " " + autor.getApellido());
		}
		System.out.println("Fecha de publicación: " + fecha_publicacion);
		System.out.println("Estado del recurso: " + estado);
		System.out.println("Puntuación: " + rate_promedio + "/10");
		System.out.println("Reseñas: " + (reseñas.size() == 0 ? "No hay reseñas" : ""));
		for(Reseña reseña : reseñas) {
			System.out.println(reseña.getUsuarioInfo() + " " + reseña.getCalificacion() + ": " + reseña.getDescripcion());
		}
	}
	
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public EstadoRecurso getEstado() {
		return estado;
	}

	public void setEstado(EstadoRecurso estado) {
		this.estado = estado;
	}
	
	
}
