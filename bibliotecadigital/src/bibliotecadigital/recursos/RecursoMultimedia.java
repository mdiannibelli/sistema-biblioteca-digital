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
		this.autores = autores != null ? autores : new ArrayList<Autor>();
		this.fecha_publicacion = fecha_publicacion != null ? fecha_publicacion : LocalDate.now();
		this.estado = estado != null ? estado : estado.DISPONIBLE;
		this.rate_promedio = rate_promedio;
		this.reseñas = reseñas != null ? reseñas : new ArrayList<Reseña>();
	}
}
