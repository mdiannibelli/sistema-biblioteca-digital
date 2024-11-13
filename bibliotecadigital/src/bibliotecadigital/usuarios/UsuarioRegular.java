package bibliotecadigital.usuarios;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;

public class UsuarioRegular extends Usuario {
	public UsuarioRegular(String nombre, String apellido, String email) {
		super(nombre, apellido, email, 3); //TODO '3' Make it a constant
	}

	@Override
	public void prestar(RecursoMultimedia recurso) {
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
	
}
