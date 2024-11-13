package bibliotecadigital.usuarios;

import bibliotecadigital.interfaces.Administrar;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;

public class UsuarioAdministrador extends Usuario implements Administrar {
	public UsuarioAdministrador(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Integer.MAX_VALUE); //TODO 'Integer.MAX_VALUE' Make it a constant
	}

	@Override
	public void prestar(RecursoMultimedia recurso) {}
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
}
