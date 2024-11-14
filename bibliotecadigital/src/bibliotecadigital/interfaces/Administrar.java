package bibliotecadigital.interfaces;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public interface Administrar {
	public void gestionarRecurso(RecursoMultimedia recurso);
	public void gestionarUsuario(Usuario usuario);
	public void accederEstadisticas();
	public void generarReporte();
	public void mostrarPrestamos(Biblioteca biblioteca);
	public void mostrarGeneros();
	public void modificarGenero(Genero genero);
}
