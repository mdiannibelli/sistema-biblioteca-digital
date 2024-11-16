package bibliotecadigital.interfaces;

import java.util.List;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public interface SistemaRecomendaciones {
	public List<RecursoMultimedia> obtenerRecomendaciones(Biblioteca biblioteca, Usuario usuario);
}
