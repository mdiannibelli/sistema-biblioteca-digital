package bibliotecadigital.usuarios;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;

public class UsuarioRegular extends Usuario {
	public UsuarioRegular(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Constantes.MAX_PRESTAMOS_USUARIO_REGULAR);
	}

	@Override
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso) {
		// 1. Verificar si el recurso corresponde a la biblioteca
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso no se encuentra disponible en la biblioteca");
			return;
		}
		
		// 2. Verificar si el recurso esta disponible
		if(recurso.getEstado() != EstadoRecurso.DISPONIBLE) {
			System.out.println("Recurso no disponible");
			return;
		}
		// 3. Verificar la cantidad de prestamos del usuario
		if(this.prestamos.size() > Constantes.MAX_PRESTAMOS_USUARIO_REGULAR) {
			System.out.println("Haz alcanzado el límite de prestamos");
			return;
		}
		// 4. Crear el prestamo 
		Prestamo nuevoPrestamo = new Prestamo(this, recurso);

		// 5. Agregar el prestamo a la lista de prestamos del usuario
		this.prestamos.add(nuevoPrestamo);
		
		// 6. Agrego el prestamo a la biblioteca
		biblioteca.agregarPrestamo(nuevoPrestamo);
		
		
		// 7. Cambiar el estado del recurso
		nuevoPrestamo.setEstado(EstadoPrestamo.ACTIVO);
		
		System.out.println("Prestamo " + nuevoPrestamo.getId() + " asignado exitosamente!");
	}

	@Override
	public void renovar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver(Biblioteca biblioteca, RecursoMultimedia recurso) {
		// 1. Verificar si el recurso existe en la biblioteca
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso a devolver no existe");
			return;
		}
		
		// 2. Verificar si el recurso está prestado al usuario
		Prestamo prestamoEncontrado = null;
		for(Prestamo prestamo : this.getPrestamos()) {
			if(prestamo.getRecurso().equals(recurso) && prestamo.getEstado() == EstadoPrestamo.ACTIVO) {
				prestamoEncontrado = prestamo;
				break;
			}
		}
		
		if (prestamoEncontrado == null) {
	        System.out.println("El usuario no tiene un préstamo activo con el recurso a devolver");
	        return;
	    }
		
		// 3. Cambiar el estado del préstamo a "DEVUELTO" o "FINALIZADO" en la biblioteca
		prestamoEncontrado.setEstado(EstadoPrestamo.FINALIZADO);
		
		// 4. Cambiamos el estado del recurso
		recurso.setEstado(EstadoRecurso.DISPONIBLE);
		
		// 5. Eliminar el prestamo de la lista de prestamos del usuario
		this.getPrestamos().remove(prestamoEncontrado);
		
		System.out.println("El recurso " + recurso.getTitulo() + " ha sido devuelto exitosamente.");
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
