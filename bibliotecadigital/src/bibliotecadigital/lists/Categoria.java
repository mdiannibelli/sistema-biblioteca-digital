package bibliotecadigital.lists;

import java.util.UUID;

public class Categoria {
	private String categoria;
	private String descripcion;
	private UUID id;
	
	public Categoria(String categoria, String descripcion) {
		this.id = UUID.randomUUID();
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	
	public UUID getCategoriaId() {
		return id;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
