package bibliotecadigital.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.lists.Reseña;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public interface Administrar {
	public void listarRecursos(Biblioteca biblioteca);
	public void agregarRecurso(Biblioteca biblioteca, RecursoMultimedia recurso);
	public void eliminarRecurso(Biblioteca biblioteca, UUID recursoId);
	public void modificarRecurso(Biblioteca biblioteca, UUID recursoId, String titulo, List<Autor> autores, EstadoRecurso estado, Categoria categoria, List<Reseña> reseñas);
	public void crearCategoria(Biblioteca biblioteca, Categoria categoria);
	public void eliminarCategoria(Biblioteca biblitoeca, UUID categoriaId);
	public void mostrarCategorias(Biblioteca biblioteca);
	public void listarUsuarios(Biblioteca biblioteca);
	public void crearUsuario(Biblioteca biblioteca, Usuario usuario);
	public void eliminarUsuario(Biblioteca biblioteca, UUID usuarioId);
	public void modificarUsuario(Biblioteca biblioteca, UUID usuarioId, String nombre, String apellido, String email, int limite_prestamos_simultaneos);
	public void mostrarPrestamos(Biblioteca biblioteca);
	public void modificarPrestamo(Biblioteca biblioteca, UUID prestamoId, RecursoMultimedia recurso, LocalDate fechaVencimiento, EstadoPrestamo estado);
	public void mostrarRecursosMejorCalificados(Biblioteca biblioteca);
	public void mostrarRecursosMasPrestadosPorCategoria(Biblioteca biblioteca);
}
