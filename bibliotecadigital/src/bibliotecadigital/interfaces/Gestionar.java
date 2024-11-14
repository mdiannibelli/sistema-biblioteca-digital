package bibliotecadigital.interfaces;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;

public interface Gestionar {
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void renovar(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void devolver(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void verificarVencimiento(RecursoMultimedia recurso);
	public void mostrarReseñas(RecursoMultimedia recurso);
	public void escribirReseña(RecursoMultimedia recurso, String descripcion, double calificacion);
}
