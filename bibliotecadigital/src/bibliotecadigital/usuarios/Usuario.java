package bibliotecadigital.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bibliotecadigital.interfaces.Gestionar;
import bibliotecadigital.lists.Favorito;
import bibliotecadigital.recursos.Prestamo;

public abstract class Usuario implements Gestionar {
	protected UUID id;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected List<Prestamo> prestamos;
	protected List<Favorito> favoritos;
	protected int limite_prestamos_simultaneos;
	
	public Usuario(String nombre, String apellido, String email, int limite_prestamos_simultaneos) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.prestamos = new ArrayList<Prestamo>();
		this.favoritos = new ArrayList<Favorito>();
		this.limite_prestamos_simultaneos = limite_prestamos_simultaneos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public int getLimite_prestamos_simultaneos() {
		return limite_prestamos_simultaneos;
	}

	public void setLimite_prestamos_simultaneos(int limite_prestamos_simultaneos) {
		this.limite_prestamos_simultaneos = limite_prestamos_simultaneos;
	}

	public UUID getId() {
		return id;
	}
	
	
}
