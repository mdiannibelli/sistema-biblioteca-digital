package bibliotecadigital.usuarios;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.interfaces.Administrar;
import bibliotecadigital.lists.Genero;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;

public class UsuarioAdministrador extends Usuario implements Administrar {
	public UsuarioAdministrador(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Constantes.MAX_PRESTAMOS_USUARIO_PREMIUM);
	}

	@Override
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso) {}
	@Override
	public void renovar(Prestamo prestamo) {}
	@Override
	public void devolver(RecursoMultimedia recurso) {}
	@Override
	public void verificarVencimiento(Prestamo prestamo) {}

	
	@Override
	public void gestionarRecurso(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gestionarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accederEstadisticas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generarReporte() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarReseñas(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPrestamos(Biblioteca biblioteca) {
		if(biblioteca.getPrestamos().size() <= 0) {
			System.out.println("No hay prestamos disponibles");
			return;
		}
		
		for(Prestamo prestamo : biblioteca.getPrestamos()) {
			System.out.println(prestamo.getId() + ": " + "iniciado en " + prestamo.getFechaInicio() + ", fecha de vencimiento " + prestamo.getFechaVencimiento() + ". ESTADO: " + prestamo.getEstado());
		}
	}

	@Override
	public void escribirReseña(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarGeneros() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarGenero(Genero genero) {
		// TODO Auto-generated method stub
		
	}

	
}
