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
	 
	public Biblioteca(String id, String nombre, List<RecursoMultimedia> recursos_multimedias, List<Usuario> usuarios, List<Prestamo> prestamos) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.recursos_multimedias = new ArrayList<RecursoMultimedia>();
		this.usuarios = new HashSet<Usuario>();
		this.prestamos = new ArrayList<Prestamo>();
	}
}
