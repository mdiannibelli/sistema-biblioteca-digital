package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.List;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.Formatos;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.lists.Reseña;

public class LibrosElectronicos extends RecursoMultimedia {
	protected int numero_paginas;
	protected Formatos formato;
	protected double tamaño_archivo;
	protected String ISBN;
	
	public LibrosElectronicos(String titulo, List<Autor> autores, LocalDate fecha_publicacion, Genero genero, EstadoRecurso estado, double rate_promedio, List<Reseña> reseñas, int numero_paginas, Formatos formato, double tamaño_archivo, String ISBN) {
		super(titulo, autores, fecha_publicacion, genero, estado, rate_promedio, reseñas);
		this.numero_paginas = numero_paginas;
		this.formato = formato;
		this.tamaño_archivo = tamaño_archivo;
		this.ISBN = ISBN;
		this.estado = estado != null ? estado : EstadoRecurso.DISPONIBLE;
	}
	
	public LibrosElectronicos(String titulo, LocalDate fecha_publicacion, Genero genero, double rate_promedio, int numero_paginas, Formatos formato, double tamaño_archivo, String ISBN) {
        super(titulo, null, fecha_publicacion, genero, null, rate_promedio, null);
        this.numero_paginas = numero_paginas;
        this.formato = formato;
        this.tamaño_archivo = tamaño_archivo;
        this.ISBN = ISBN;
    }

	public int getNumero_paginas() {
		return numero_paginas;
	}

	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
	}

	public Formatos getFormato() {
		return formato;
	}

	public void setFormato(Formatos formato) {
		this.formato = formato;
	}

	public double getTamaño_archivo() {
		return tamaño_archivo;
	}

	public void setTamaño_archivo(double tamaño_archivo) {
		this.tamaño_archivo = tamaño_archivo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
}
