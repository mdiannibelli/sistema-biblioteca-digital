package bibliotecadigital.lists;

import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public class Favorito {
	protected RecursoMultimedia recurso;
	protected Usuario usuario;
	
	public Favorito(RecursoMultimedia recurso, Usuario usuario) {
		this.recurso = recurso;
		this.usuario = usuario;
	}
}
