package bibliotecadigital;

import java.time.LocalDate;

import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.enums.Formatos;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.recursos.AudioLibros;
import bibliotecadigital.recursos.LibrosElectronicos;
import bibliotecadigital.recursos.RevistaDigitales;
import bibliotecadigital.usuarios.UsuarioAdministrador;
import bibliotecadigital.usuarios.UsuarioPremium;
import bibliotecadigital.usuarios.UsuarioRegular;

public class Main {

	public static void main(String[] args) {
		// Create library
		Biblioteca biblioteca = new Biblioteca("Arcos", null, null, null);
		//System.out.println("Biblioteca" + " " + biblioteca.getNombre() + ", ID: " + biblioteca.getId());
	
		// Create users
		UsuarioRegular marcos = new UsuarioRegular("Marcos", "Iannibelli", "mdiannibelli@gmail.com");
		UsuarioPremium thiago = new UsuarioPremium("Thiago", "Andrés", "thiagoandres@gmail.com");
		UsuarioAdministrador admin = new UsuarioAdministrador("Admin", "1", "administrador1@gmail.com");
		biblioteca.agregarUsuario(marcos);
		biblioteca.agregarUsuario(thiago);
		biblioteca.agregarUsuario(admin);
		
		// Create resources
		Genero ficcion = new Genero("Ficción", "Género para recursos de ciencia ficción");
		Genero noticias = new Genero("Noticias", "Categoría de noticias");
		Genero podcasts = new Genero("Podcasts", "Categoría para podcasts");
		LibrosElectronicos pdf = new LibrosElectronicos("Harry Potter y La Piedra Filosofal", LocalDate.now(), ficcion, 9.2, 382, Formatos.PDF, 124.9, "KGJQIRJ29ASFJ");
		//pdf.mostrarInfo();
		
		RevistaDigitales revista = new RevistaDigitales("Diario Clarin", LocalDate.now(), noticias, 6.0, 43, "1t8219");
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
		
		marcos.escribirReseña(pdf, "Muy bueno y entretenido!", 9.2);
		marcos.mostrarReseñas(pdf);

		marcos.renovar(biblioteca, pdf);
		admin.mostrarPrestamos(biblioteca);
		
		marcos.verificarVencimiento(pdf);
		admin.mostrarPrestamos(biblioteca);
		
	}

}
