package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.List;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.lists.Reseña;
import constants.Constantes;

public class AudioLibros extends RecursoMultimedia {
	protected double duracion_total;
	protected String idioma;
	
	public AudioLibros(String titulo, List<Autor> autores, LocalDate fecha_publicacion, Categoria categoria, EstadoRecurso estado, double rate_promedio, List<Reseña> reseñas, double duracion_total, String idioma) {
		super(titulo, autores, fecha_publicacion, categoria, estado, rate_promedio, reseñas);
		this.duracion_total = duracion_total;
		this.idioma = idioma;
	}
	
	public AudioLibros(String titulo, LocalDate fecha_publicacion, Categoria categoria, double rate_promedio, double duracion_total, String idioma) {
		super(titulo, null, fecha_publicacion, categoria, null, rate_promedio, null);
		this.duracion_total = duracion_total;
		this.idioma = idioma != null ? idioma : Constantes.DEFAULT_LANGUAGE;
	}

	public double getDuracion_total() {
		return duracion_total;
	}

	public void setDuracion_total(double duracion_total) {
		this.duracion_total = duracion_total;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
}
