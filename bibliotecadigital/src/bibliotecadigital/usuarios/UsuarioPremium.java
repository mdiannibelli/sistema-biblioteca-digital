package bibliotecadigital.usuarios;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;

public class UsuarioPremium extends Usuario {
	public UsuarioPremium(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Constantes.MAX_PRESTAMOS_USUARIO_PREMIUM);
	}

	@Override
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renovar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verificarVencimiento(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarReseñas(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirReseña(RecursoMultimedia recurso) {
		// TODO Auto-generated method stub
		
	}

	
}
