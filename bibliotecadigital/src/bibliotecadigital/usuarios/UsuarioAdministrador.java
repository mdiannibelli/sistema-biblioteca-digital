package bibliotecadigital.usuarios;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.interfaces.Administrar;
import bibliotecadigital.lists.Autor;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.lists.Reseña;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;
import utils.CalcularPromedioReseñas;
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
	public void listarRecursos(Biblioteca biblioteca) {
		if(biblioteca.getRecursos_multimedias().isEmpty()) {
			System.out.println("No se han encontrado recursos");
			return;
		}
		for(RecursoMultimedia recurso : biblioteca.getRecursos_multimedias()) {
			recurso.mostrarInfo();
		}
	}
	
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
	public void listarUsuarios(Biblioteca biblioteca) {
		if(biblioteca.getUsuarios().isEmpty()) {
			System.out.println("No se han encontrado usuarios");
			return;
		}
		for(Usuario usuario : biblioteca.getUsuarios()) {
			System.out.println(usuario.getId() + " " + usuario.getNombre() + " " + usuario.getApellido() + " - Límite de prestamos: " + (usuario.getLimite_prestamos_simultaneos() > 100 ? "Sin límite" : usuario.getLimite_prestamos_simultaneos()));
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

	@Override
	public void modificarUsuario(Biblioteca biblioteca, UUID usuarioId, String nombre, String apellido, String email, int limite_prestamos_simultaneos) {
		Usuario usuarioEncontrado = UsuarioUtils.buscarUsuarioPorId(biblioteca.getUsuarios(), usuarioId);
		if (usuarioEncontrado == null) {
		    System.out.println("No se ha encontrado el usuario");
		    return;
		}
		
		if(nombre != null) usuarioEncontrado.setNombre(nombre);
		if(apellido != null) usuarioEncontrado.setApellido(apellido);
		if(email != null) usuarioEncontrado.setEmail(email);
		if(limite_prestamos_simultaneos > 0) usuarioEncontrado.setLimite_prestamos_simultaneos(limite_prestamos_simultaneos);
		System.out.println("Usuario modificado con éxito");
		System.out.println(usuarioEncontrado.toString());
	}

	@Override
	public void mostrarPrestamos(Biblioteca biblioteca) {
		if(biblioteca.getPrestamos().size() <= 0) {
			System.out.println("No hay prestamos");
			return;
		}
		for(Prestamo prestamo : biblioteca.getPrestamos()) {
			System.out.println("Prestamo " + prestamo.getId() + " iniciado en " + prestamo.getFechaInicio() + " - vencimiento " + prestamo.getFechaVencimiento() + ". ESTADO: " + prestamo.getEstado());
		}
	}

	@Override
	public void modificarPrestamo(Biblioteca biblioteca, UUID prestamoId, RecursoMultimedia recurso, LocalDate fechaVencimiento, EstadoPrestamo estado) {
		Prestamo prestamoEncontrado = null;
		for(Prestamo prestamo : biblioteca.getPrestamos()) {
			if(prestamo.getId().equals(prestamoId)) {
				prestamoEncontrado = prestamo;
			}
		}
		if(prestamoEncontrado == null) {
			System.out.println("No se ha podido encontrar el prestamo");
			return;
		}
		
		if(recurso != null) prestamoEncontrado.setRecurso(recurso);
		if(fechaVencimiento != null) prestamoEncontrado.setFechaVencimiento(fechaVencimiento);
		if(estado != null) prestamoEncontrado.setEstado(estado);
		System.out.println("Prestamo " + prestamoEncontrado.getId() + " modificado con éxito");
		System.out.println(prestamoEncontrado.toString());
	}

	@Override
	public void mostrarRecursosMejorCalificados(Biblioteca biblioteca) {
		List<RecursoMultimedia> recursos = biblioteca.getRecursos_multimedias();
		if(recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}
		
		List<RecursoMultimedia> mejoresRecursos = recursos.stream()
				.filter(recurso -> !recurso.getReseñas().isEmpty())
				.sorted((a,b) -> Double.compare(CalcularPromedioReseñas.calcularPromedio(a.getReseñas()), CalcularPromedioReseñas.calcularPromedio(b.getReseñas())))
				.limit(5)
				.collect(Collectors.toList());
		
		if (mejoresRecursos.isEmpty()) {
	        System.out.println("No hay recursos con calificaciones en la biblioteca.");
	        return;
	    }
	     System.out.println("Top 5 recursos mejor calificados:");
	     for (RecursoMultimedia recurso : mejoresRecursos) {
	         System.out.println("Título: " + recurso.getTitulo());
	         System.out.println("Calificación promedio: " + CalcularPromedioReseñas.calcularPromedio(recurso.getReseñas()));
	         System.out.println("----------");
	     }
	}

	@Override
	public void mostrarRecursosMasPrestadosPorCategoria(Biblioteca biblioteca) {
		Set<Categoria> categorias = biblioteca.getCategorias();
		if(categorias.isEmpty()) {
			System.out.println("No hay categorias");
			return;
		}
		System.out.println("Recursos más prestados por categoría:"); 
		for(Categoria categoria : categorias) {
			List<RecursoMultimedia> recursosPorCategoria = biblioteca.getRecursos_multimedias()
					.stream()
					.filter(recurso -> recurso.getCategoria().equals(categoria))
					.sorted((a, b) -> Integer.compare(a.getVecesPrestado(), b.getVecesPrestado()))
					.limit(1)
					.collect(Collectors.toList());
			if(recursosPorCategoria.isEmpty()) {
				System.out.println("Categoria " + categoria.getCategoria() + " - No hay recursos disponibles.");
				return;
			}
			RecursoMultimedia recurso = recursosPorCategoria.get(0);
			System.out.println("Categoría: " + categoria.getCategoria());
            System.out.println("Recurso más prestado: " + recurso.getTitulo() + " (Veces prestado: " + recurso.getVecesPrestado() + ")");
		}
	}
}
