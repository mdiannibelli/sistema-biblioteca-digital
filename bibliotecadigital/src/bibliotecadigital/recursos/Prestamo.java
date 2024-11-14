package bibliotecadigital.recursos;

import java.time.LocalDate;
import java.util.UUID;

import bibliotecadigital.enums.EstadoPrestamo;
import bibliotecadigital.usuarios.Usuario;
import constants.Constantes;

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
		this.fechaVencimiento = fechaVencimiento != null ? fechaVencimiento : LocalDate.now().plusDays(Constantes.DIAS_PRESTAMO);
		this.estado = EstadoPrestamo.ACTIVO;
	}
	
	public Prestamo(Usuario usuario, RecursoMultimedia recurso) {
		this.id = UUID.randomUUID();
		this.usuario = usuario; //TODO Make composition
		this.recurso = recurso; //TODO Make composition
		this.fechaInicio = LocalDate.now();
		this.fechaVencimiento = LocalDate.now().plusDays(Constantes.DIAS_PRESTAMO);
		this.estado = EstadoPrestamo.ACTIVO;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}

	public RecursoMultimedia getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoMultimedia recurso) {
		this.recurso = recurso;
	}
	
	
	
}
