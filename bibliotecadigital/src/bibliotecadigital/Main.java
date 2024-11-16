package bibliotecadigital;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.Formatos;
import bibliotecadigital.interfaces.SistemaRecomendaciones;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.recursos.Articulo;
import bibliotecadigital.recursos.AudioLibros;
import bibliotecadigital.recursos.LibrosElectronicos;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.recursos.RevistaDigitales;
import bibliotecadigital.usuarios.UsuarioAdministrador;
import bibliotecadigital.usuarios.UsuarioPremium;
import bibliotecadigital.usuarios.UsuarioRegular;
import recomendaciones.RecomendacionesPorCalificaciones;
import recomendaciones.RecomendacionesPorHistorial;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Create library
		Biblioteca biblioteca = new Biblioteca("Arcos");
	
		// Create users
		UsuarioRegular marcos = new UsuarioRegular("Marcos", "Iannibelli", "mdiannibelli@gmail.com");
		UsuarioPremium thiago = new UsuarioPremium("Thiago", "Andrés", "thiagoandres@gmail.com");
		UsuarioAdministrador admin = new UsuarioAdministrador("Admin", "1", "administrador1@gmail.com");
		biblioteca.agregarUsuario(marcos);
		biblioteca.agregarUsuario(thiago);
		biblioteca.agregarUsuario(admin);
		
		// Create categories
		Categoria ficcion = new Categoria("Ficción", "Género para recursos de ciencia ficción");
		Categoria noticias = new Categoria("Noticias", "Categoría de noticias");
		Categoria podcasts = new Categoria("Podcasts", "Categoría para podcasts");
		biblioteca.getCategorias().add(ficcion);
		biblioteca.getCategorias().add(noticias);
		biblioteca.getCategorias().add(podcasts);
		
		// Create resources
		LibrosElectronicos pdf = new LibrosElectronicos("Harry Potter y La Piedra Filosofal", LocalDate.now(), ficcion, 9.2, 382, Formatos.PDF, 124.9, "KGJQIRJ29ASFJ");
		//pdf.mostrarInfo();
		
		Articulo articulo1 = new Articulo("Peces del Océano en peligro", "Millones de peces en el Océano Atlántico...");
		Articulo articulo2 = new Articulo("El tiburón asiatico más peligroso", "Un tiburón nunca antes visto...");
		RevistaDigitales revista = new RevistaDigitales("Diario Clarin", LocalDate.now(), noticias, 6.0, 43, "1t8219", articulo1);
		revista.agregarOtroArticulo(articulo2);
		//revista.getLista_articulos();
		//revista.mostrarInfo();
		
		AudioLibros audioLibro = new AudioLibros("Jordi Wild Podcast #1", LocalDate.now(), podcasts, 10, 2.20, "ES");
		//audioLibro.mostrarInfo();
		
		biblioteca.agregarRecurso(pdf);
		biblioteca.agregarRecurso(revista);
		biblioteca.agregarRecurso(audioLibro);
		
		// Actions
		marcos.prestar(biblioteca, pdf);
		admin.mostrarPrestamos(biblioteca);

		
		marcos.devolver(biblioteca, pdf);		
		thiago.prestar(biblioteca, audioLibro);
		
		admin.mostrarPrestamos(biblioteca);

		// Review
		System.out.println("Para realizar una reseña introduzca su opinión");
		String opinion = scn.nextLine();
		System.out.println("Ahora su puntuación");
		double puntuacion = scn.nextDouble();
		marcos.escribirReseña(pdf, opinion, puntuacion);
		marcos.mostrarReseñas(pdf);
		
		marcos.renovar(biblioteca, pdf);
		admin.mostrarPrestamos(biblioteca);
		
		marcos.verificarVencimiento(pdf);
		admin.mostrarPrestamos(biblioteca);
		
		
		// ADMINISTRADOR:
		
		admin.mostrarCategorias(biblioteca);
		admin.crearCategoria(biblioteca, new Categoria("Plantas", "Fauna y plantas"));
		admin.eliminarCategoria(biblioteca, ficcion.getCategoriaId());
		admin.mostrarCategorias(biblioteca);
		
		UsuarioPremium matias = new UsuarioPremium("Matias", "Paz", "matiaspaz@..");
		admin.crearUsuario(biblioteca, matias);
		admin.eliminarUsuario(biblioteca, marcos.getId());
		admin.modificarUsuario(biblioteca, matias.getId(), null, null, null, 0); // no modifies
		admin.modificarUsuario(biblioteca, thiago.getId(), null, null, "thiagonuevoemail@..", 0); // new email
		admin.listarUsuarios(biblioteca);
		
		
		//admin.listarRecursos(biblioteca);
		//admin.mostrarRecursosMasPrestadosPorCategoria(biblioteca);
		//admin.mostrarRecursosMejorCalificados(biblioteca);
		
		
		SistemaRecomendaciones recomendarPorCalificaciones = new RecomendacionesPorCalificaciones();
		SistemaRecomendaciones recomendarPorHistorial = new RecomendacionesPorHistorial();
		
		List<RecursoMultimedia> recomendacionesHistorial = recomendarPorHistorial.obtenerRecomendaciones(biblioteca, thiago);
		List<RecursoMultimedia> recomendacionesCalificaciones = recomendarPorCalificaciones.obtenerRecomendaciones(biblioteca, thiago);
		if(recomendacionesHistorial == null) {
			System.out.println("No se ha podido obtener recomendaciones por historial");
		} else {
			System.out.println("Recomendaciones por historial de " + thiago.getNombre() + ":");
			recomendacionesHistorial.forEach(r -> System.out.println(r.getTitulo()));			
		}
		
		if(recomendacionesCalificaciones == null) {
			System.out.println("No se ha podido obtener recomendaciones por calificaciones");
		} else {
			System.out.println("Recomendaciones por calificación de " + thiago.getNombre() + ":");
	        recomendacionesCalificaciones.forEach(r -> System.out.println(r.getTitulo()));
		}
		
	}

}