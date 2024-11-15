package bibliotecadigital;

import java.time.LocalDate;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.Formatos;
import bibliotecadigital.lists.Categoria;
import bibliotecadigital.recursos.Articulo;
import bibliotecadigital.recursos.AudioLibros;
import bibliotecadigital.recursos.LibrosElectronicos;
import bibliotecadigital.recursos.RevistaDigitales;
import bibliotecadigital.usuarios.UsuarioAdministrador;
import bibliotecadigital.usuarios.UsuarioPremium;
import bibliotecadigital.usuarios.UsuarioRegular;

public class Main {

	public static void main(String[] args) {
		// Create library
		Biblioteca biblioteca = new Biblioteca("Arcos");
		//System.out.println("Biblioteca" + " " + biblioteca.getNombre() + ", ID: " + biblioteca.getId());
	
		// Create users
		UsuarioRegular marcos = new UsuarioRegular("Marcos", "Iannibelli", "mdiannibelli@gmail.com");
		UsuarioPremium thiago = new UsuarioPremium("Thiago", "Andrés", "thiagoandres@gmail.com");
		UsuarioAdministrador admin = new UsuarioAdministrador("Admin", "1", "administrador1@gmail.com");
		biblioteca.agregarUsuario(marcos);
		biblioteca.agregarUsuario(thiago);
		biblioteca.agregarUsuario(admin);
		
		// Create resources
		Categoria ficcion = new Categoria("Ficción", "Género para recursos de ciencia ficción");
		Categoria noticias = new Categoria("Noticias", "Categoría de noticias");
		Categoria podcasts = new Categoria("Podcasts", "Categoría para podcasts");
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
		admin.mostrarPrestamos(biblioteca);
		
		//TODO Usar un prompt para que el usuario ingrese la puntuación y la reseña
		marcos.escribirReseña(pdf, "Muy bueno y entretenido!", 9.2);
		marcos.mostrarReseñas(pdf);

		marcos.renovar(biblioteca, pdf);
		admin.mostrarPrestamos(biblioteca);
		
		marcos.verificarVencimiento(pdf);
		admin.mostrarPrestamos(biblioteca);
		
	}

}
