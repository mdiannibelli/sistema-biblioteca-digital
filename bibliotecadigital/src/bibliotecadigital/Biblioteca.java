package bibliotecadigital;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;

public class Biblioteca {
	private UUID id;
	public String nombre;
	public List<RecursoMultimedia> recursos_multimedias;
	private Set<Usuario> usuarios;
	private List<Prestamo> prestamos;
	 
	public Biblioteca(String nombre, List<RecursoMultimedia> recursos_multimedias, List<Usuario> usuarios, List<Prestamo> prestamos) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.recursos_multimedias = new ArrayList<RecursoMultimedia>();
		this.usuarios = new HashSet<Usuario>();
		this.prestamos = new ArrayList<Prestamo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UUID getId() {
		return id;
	}

	public List<RecursoMultimedia> getRecursos_multimedias() {
		return recursos_multimedias;
	}

	public void setRecursos_multimedias(List<RecursoMultimedia> recursos_multimedias) {
		this.recursos_multimedias = recursos_multimedias;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void agregarPrestamo(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void agregarRecurso(RecursoMultimedia recurso) {
		this.recursos_multimedias.add(recurso);	
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
	
}
