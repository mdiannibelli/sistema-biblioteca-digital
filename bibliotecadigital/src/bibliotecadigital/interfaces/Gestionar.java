package bibliotecadigital.interfaces;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;

public interface Gestionar {
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void renovar(Prestamo prestamo);
	public void devolver(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void verificarVencimiento(Prestamo prestamo);
	public void mostrarReseñas(RecursoMultimedia recurso);
	public void escribirReseña(RecursoMultimedia recurso);
}
