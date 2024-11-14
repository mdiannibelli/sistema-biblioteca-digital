package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.Formatos;
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
		this.lista_articulos = lista_articulos != null ? lista_articulos : new ArrayList<>();
	}
	
	public RevistaDigitales(String titulo, LocalDate fecha_publicacion, Genero genero, double rate_promedio, int numero_edicion, String ISSN) {
		super(titulo, null, fecha_publicacion, genero, null, rate_promedio, null);
        this.numero_edicion = numero_edicion;
        this.periodicidad = PeriodicidadRevista.SEMNANAL;
        this.ISSN = ISSN;
        this.lista_articulos = new ArrayList<>();
    }

	public int getNumero_edicion() {
		return numero_edicion;
	}

	public void setNumero_edicion(int numero_edicion) {
		this.numero_edicion = numero_edicion;
	}

	public PeriodicidadRevista getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(PeriodicidadRevista periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	public List<Articulo> getLista_articulos() {
		return lista_articulos;
	}

	public void setLista_articulos(List<Articulo> lista_articulos) {
		this.lista_articulos = lista_articulos;
	}
	
	
}
