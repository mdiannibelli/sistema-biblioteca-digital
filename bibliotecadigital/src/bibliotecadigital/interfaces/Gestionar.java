package bibliotecadigital.interfaces;

import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;

public interface Gestionar {
	public void prestar(RecursoMultimedia recurso);
	public void renovar(Prestamo prestamo);
	public void devolver(RecursoMultimedia recurso);
	public void verificarVencimiento(Prestamo prestamo);
}
