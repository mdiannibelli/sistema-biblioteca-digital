package bibliotecadigital.interfaces;

import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public interface Administrar {
	public void gestionarRecurso(RecursoMultimedia recurso);
	public void gestionarUsuario(Usuario usuario);
	public void accederEstadisticas();
	public void generarReporte();
}
