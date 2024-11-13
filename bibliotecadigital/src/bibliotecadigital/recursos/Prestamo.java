package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.UUID;

import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.usuarios.Usuario;

public class Prestamo {
	protected UUID id;
	protected Usuario usuario;
	protected RecursoMultimedia recurso;
	protected LocalDate fechaInicio;
	protected LocalDate fechaVencimiento;
	protected EstadoPrestamo estado;
	
	public Prestamo(Usuario usuario, RecursoMultimedia recurso, LocalDate fechaVencimiento) {
		this.id = UUID.randomUUID();
		this.usuario = usuario; //TODO Make composition
		this.recurso = recurso; //TODO Make composition
		this.fechaInicio = LocalDate.now();
		//TODO Make fechaVencimiento plus days a constant
		this.fechaVencimiento = fechaVencimiento != null ? fechaVencimiento : LocalDate.now().plusDays(7);
		this.estado = EstadoPrestamo.ACTIVO;
	}
}
