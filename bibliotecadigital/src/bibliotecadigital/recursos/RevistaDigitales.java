package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.PeriodicidadRevista;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.lists.Reseña;

public class RevistaDigitales extends RecursoMultimedia {
	protected int numero_edicion;
	protected PeriodicidadRevista periodicidad;
	protected String ISSN;
	protected List<Articulo> lista_articulos;
	
	public RevistaDigitales(String titulo, List<Autor> autores, LocalDate fecha_publicacion, Genero genero, EstadoRecurso estado, double rate_promedio, List<Reseña> reseñas, int numero_edicion, PeriodicidadRevista periodicidad, String ISSN, List<Articulo> lista_articulos) {
		super(titulo, autores, fecha_publicacion, genero, estado, rate_promedio, reseñas);
		this.numero_edicion = numero_edicion;
		this.periodicidad = periodicidad != null ? periodicidad : PeriodicidadRevista.SEMNANAL;
		this.ISSN = ISSN;
		this.lista_articulos = lista_articulos != null ? lista_articulos : new ArrayList<Articulo>();
	}
}
