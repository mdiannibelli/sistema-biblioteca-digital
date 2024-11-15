package bibliotecadigital.usuarios;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.enums.EstadoRecurso;
import bibliotecadigital.lists.Reseña;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import constants.Constantes;

public class UsuarioPremium extends Usuario {
	public UsuarioPremium(String nombre, String apellido, String email) {
		super(nombre, apellido, email, Constantes.MAX_PRESTAMOS_USUARIO_PREMIUM);
	}

	@Override
	public void prestar(Biblioteca biblioteca, RecursoMultimedia recurso) {
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso no se encuentra disponible en la biblioteca");
			return;
		}
		
		if(recurso.getEstado() != EstadoRecurso.DISPONIBLE) {
			System.out.println("Recurso no disponible");
			return;
		}

		if(this.prestamos.size() > Constantes.MAX_PRESTAMOS_USUARIO_REGULAR) {
			System.out.println("Haz alcanzado el límite de prestamos");
			return;
		}

		Prestamo nuevoPrestamo = new Prestamo(this, recurso);
		recurso.incrementarVecesPrestado();
		this.prestamos.add(nuevoPrestamo);
		biblioteca.agregarPrestamo(nuevoPrestamo);
		nuevoPrestamo.setEstado(EstadoPrestamo.ACTIVO);
		
		System.out.println("Prestamo " + nuevoPrestamo.getId() + " asignado exitosamente!");
	}

	@Override
	public void renovar(Biblioteca biblioteca, RecursoMultimedia recurso) {
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso a renovar no existe");
			return;
		} 
		
		Prestamo prestamoEncontrado = null;
		for(Prestamo prestamo : this.getPrestamos()) {
			if(prestamo.getRecurso().equals(recurso) && prestamo.getEstado() == EstadoPrestamo.FINALIZADO) {
				prestamoEncontrado = prestamo;
				break;
			}
		}
		
		if (prestamoEncontrado == null) {
	        System.out.println("El usuario no tiene un préstamo finalizado con el recurso a renovar");
	        return;
	    }

		prestamoEncontrado.setFechaInicio(LocalDate.now());
		prestamoEncontrado.setFechaVencimiento(LocalDate.now().plusDays(Constantes.DIAS_PRESTAMO));
		prestamoEncontrado.setEstado(EstadoPrestamo.ACTIVO);
		recurso.setEstado(EstadoRecurso.PRESTADO);
		
		System.out.println("Prestamo renovado con éxito! Nueva fecha de vencimiento: " + prestamoEncontrado.getFechaVencimiento());
	}

	@Override
	public void devolver(Biblioteca biblioteca, RecursoMultimedia recurso) {
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso a devolver no existe");
			return;
		}
		
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
		
		prestamoEncontrado.setEstado(EstadoPrestamo.FINALIZADO);
		recurso.setEstado(EstadoRecurso.DISPONIBLE);
		
		System.out.println("El recurso " + recurso.getTitulo() + " ha sido devuelto exitosamente.");
	}

	@Override
	public void verificarVencimiento(RecursoMultimedia recurso) {
		Prestamo prestamoEncontrado = null;
		for(Prestamo prestamo : this.getPrestamos()) {
			if(prestamo.getRecurso().equals(recurso)) {
				prestamoEncontrado = prestamo;
				if(prestamo.getEstado() == EstadoPrestamo.ACTIVO) {
					System.out.println("El prestamo se encuentra activo y finaliza en " + (prestamo.getFechaVencimiento().getDayOfMonth() - LocalDate.now().getDayOfMonth()) + " días!");
					break;
				}
				
				if(prestamo.getEstado() == EstadoPrestamo.INACTIVO || prestamo.getEstado() == EstadoPrestamo.FINALIZADO) {
					System.out.println("El prestamo ha finalizado hace " + (prestamo.getFechaVencimiento().getDayOfMonth() - LocalDate.now().getDayOfMonth()) + " días!");
					break;
				}
			}
		}
		
		if(prestamoEncontrado == null) {
			System.out.println("No se ha encontrado ningún prestamo");
		}
		
	}

	@Override
	public void mostrarReseñas(RecursoMultimedia recurso) {
		if(recurso.getReseñas().size() <= 0) {
			System.out.println("El recurso por el momento no tiene reseñas");
			return;
		}
	
		for(Reseña reseña : recurso.getReseñas()) {
			System.out.println(reseña.getCalificacion() + "/10" + ", opinión: " + reseña.getDescripcion());
		}
		
	}

	@Override
	public void escribirReseña(RecursoMultimedia recurso, String descripcion, double calificacion) {
		Prestamo prestamoEncontrado = null;
		for(Prestamo prestamo : this.getPrestamos()) {
			if(prestamo.getRecurso().equals(recurso) && prestamo.getEstado() != EstadoPrestamo.ACTIVO) {
				prestamoEncontrado = prestamo;
				break;
			}	
		}
		
		if(prestamoEncontrado == null) {
			System.out.println("No se ha encontrado un prestamo finalizado con el recurso a reseñar");
			return;
		}
		
		Reseña nuevaReseña = new Reseña(this, descripcion, calificacion);
		recurso.agregarReseña(nuevaReseña);
		System.out.println("Muchas gracias "+ this.getNombre() + " por tu reseña!");
	}

	
}
