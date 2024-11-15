package bibliotecadigital.usuarios;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.interfaces.Administrar;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.lists.Reseña;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;
import utils.RecursoUtils;
import utils.UsuarioUtils;

public class UsuarioAdministrador extends Usuario implements Administrar {
	public UsuarioAdministrador(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Constantes.MAX_PRESTAMOS_USUARIO_PREMIUM);
	}

	@Override
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso) {}
	@Override
	public void renovar(Biblioteca biblioteca, RecursoMultimedia recurso) {}
	@Override
	public void devolver(Biblioteca biblioteca, RecursoMultimedia recurso) {}
	@Override
	public void verificarVencimiento(RecursoMultimedia recurso) {}
	@Override
	public void mostrarReseñas(RecursoMultimedia recurso) {}
	@Override
	public void escribirReseña(RecursoMultimedia recurso, String descripcion, double calificacion) {}

	@Override
	public void agregarRecurso(Biblioteca biblioteca, RecursoMultimedia recurso) {
		// 1. Verificar si el recurso ya existe
		if(biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso ya se encuentra en la biblioteca");
			return;
		}
		
		// 2. Agregarlo
		biblioteca.getRecursos_multimedias().add(recurso);
		System.out.println("Recurso " + recurso.getUuid() + " agregado con éxito");
	}

	@Override
	public void eliminarRecurso(Biblioteca biblioteca, UUID recursoId) {
		// 1. Buscar recurso
		RecursoMultimedia recursoEncontrado = RecursoUtils.buscarRecursoPorId(biblioteca.getRecursos_multimedias(), recursoId);
		if (recursoEncontrado == null) {
			System.out.println("No se ha encontrado el recurso en la biblioteca");
			return;
		}
		
		// 2. Eliminarlo
		biblioteca.getRecursos_multimedias().remove(recursoEncontrado);
		System.out.println("Recurso " + recursoEncontrado.getUuid() + " eliminado con éxito");
	}

	@Override
	public void modificarRecurso(Biblioteca biblioteca, UUID recursoId, String titulo, List<Autor> autores, EstadoRecurso estado, Categoria categoria, List<Reseña> reseñas) {
		// 1. Buscar recurso
		RecursoMultimedia recursoEncontrado = RecursoUtils.buscarRecursoPorId(biblioteca.getRecursos_multimedias(), recursoId);
		if (recursoEncontrado == null) {
		    System.out.println("No se ha encontrado el recurso en la biblioteca");
		    return;
		}
		
		// 2. Actualizar
		if(titulo != null) recursoEncontrado.setTitulo(titulo);
		if(autores != null) recursoEncontrado.setAutores(autores);
		if(estado != null) recursoEncontrado.setEstado(estado);
		if(categoria != null) recursoEncontrado.setCategoria(categoria);
		if(reseñas != null) recursoEncontrado.setReseñas(reseñas);
		System.out.println("Recurso actualizado con éxito!");
		recursoEncontrado.mostrarInfo();
	}

	@Override
	public void crearCategoria(Biblioteca biblioteca, Categoria categoria) {
		// 1. Verificar si ya existe una categoría igual
		for(Categoria category : biblioteca.getCategorias()) {
			if(category.getCategoria().equals(categoria.getCategoria())) {
				System.out.println("La categoría a crear ya existe");
				return;
			}
		}
		// 2. Agregar categoría
		biblioteca.getCategorias().add(categoria);
		System.out.println("Categoría " + categoria.getCategoria() + " agregada con éxito");
	}

	@Override
	public void mostrarCategorias(Biblioteca biblioteca) {
		if(biblioteca.getCategorias().size() <= 0) {
			System.out.println("No hay categorías");
			return;
		}
		for(Categoria categoria : biblioteca.getCategorias()) {
			System.out.println("Categoría: " + categoria.getCategoria() + " - " + categoria.getDescripcion());
		}
	}

	@Override
	public void crearUsuario(Biblioteca biblioteca, Usuario usuario) {
		Usuario usuarioEncontrado = null;
		for(Usuario user : biblioteca.getUsuarios()) {
			if(user.getId().equals(usuario.getId())) {
				System.out.println("Usuario ya existente");
				return;
			}
		}
		biblioteca.getUsuarios().add(usuario);
		System.out.println("Usuario " + usuario.getNombre() + " creado con éxito!");
	}

	@Override
	public void eliminarUsuario(Biblioteca biblioteca, UUID usuarioId) {
		Usuario usuarioEncontrado = UsuarioUtils.buscarUsuarioPorId(biblioteca.getUsuarios(), usuarioId);
		if (usuarioEncontrado == null) {
		    System.out.println("No se ha encontrado el usuario");
		    return;
		}
		
		biblioteca.getUsuarios().remove(usuarioEncontrado);
		System.out.println("Usuario " + usuarioEncontrado.getNombre() + " eliminado con éxito!");
	}
}
