package bibliotecadigital.interfaces;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.lists.Reseña;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public interface Administrar {
	public void agregarRecurso(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void eliminarRecurso(Biblioteca biblioteca, UUID recursoId);
	public void modificarRecurso(Biblioteca biblioteca, UUID recursoId, String titulo, List<Autor> autores, EstadoRecurso estado, Categoria categoria, List<Reseña> reseñas);
	public void crearCategoria(Biblioteca biblioteca, Categoria categoria);
	public void mostrarCategorias(Biblioteca biblioteca);
	public void crearUsuario(Biblioteca biblioteca, Usuario usuario);
	public void eliminarUsuario(Biblioteca biblioteca, UUID usuarioId);
}
