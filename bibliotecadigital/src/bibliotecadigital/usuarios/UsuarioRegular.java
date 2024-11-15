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
		recurso.incrementarVecesPrestado();

		// 5. Agregar el prestamo a la lista de prestamos del usuario
		this.prestamos.add(nuevoPrestamo);
		
		// 6. Agrego el prestamo a la biblioteca
		biblioteca.agregarPrestamo(nuevoPrestamo);
		
		
		// 7. Cambiar el estado del recurso
		nuevoPrestamo.setEstado(EstadoPrestamo.ACTIVO);
		
		System.out.println("Prestamo " + nuevoPrestamo.getId() + " asignado exitosamente!");
	}

	@Override
	public void renovar(Biblioteca biblioteca, RecursoMultimedia recurso) {
		// 1. Verificar si el recurso existe en la biblioteca
		if(!biblioteca.getRecursos_multimedias().contains(recurso)) {
			System.out.println("El recurso a renovar no existe");
			return;
		} 
		
		// 2. Verificar si el usuario tiene un prestamo finalizado con el recurso
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
		
		// 3. Cambiar las fechas del prestamo 
		prestamoEncontrado.setFechaInicio(LocalDate.now());
		prestamoEncontrado.setFechaVencimiento(LocalDate.now().plusDays(Constantes.DIAS_PRESTAMO));
		
		// 4. Cambiar el estado del prestamo
		prestamoEncontrado.setEstado(EstadoPrestamo.ACTIVO);
		
		// 5. Cambiar disponibilidad del recurso
		recurso.setEstado(EstadoRecurso.PRESTADO);
		
		System.out.println("Prestamo renovado con éxito! Nueva fecha de vencimiento: " + prestamoEncontrado.getFechaVencimiento());
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
		
		System.out.println("El recurso " + recurso.getTitulo() + " ha sido devuelto exitosamente.");
	}

	@Override
	public void verificarVencimiento(RecursoMultimedia recurso) {
		// 1. Buscar si existe un prestamo con el recurso
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
		// 1. Verificar si el recurso tiene reseñas
		if(recurso.getReseñas().size() <= 0) {
			System.out.println("El recurso por el momento no tiene reseñas");
			return;
		}
		
		// 2. Si tiene, mostrarlas
		for(Reseña reseña : recurso.getReseñas()) {
			System.out.println(reseña.getCalificacion() + "/10" + ", opinión: " + reseña.getDescripcion());
		}
		
	}

	@Override
	public void escribirReseña(RecursoMultimedia recurso, String descripcion, double calificacion) {
		// 1. Verificar si el usuario tuvo un prestamo con el recurso
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
		
		// 2. Crear la reseña
		Reseña nuevaReseña = new Reseña(this, descripcion, calificacion);
		
		// 3. Agregar reseña a la lista de reseñas del recurso
		recurso.agregarReseña(nuevaReseña);
		
		System.out.println("Muchas gracias "+ this.getNombre() + " por tu reseña!");
	}
	
}
