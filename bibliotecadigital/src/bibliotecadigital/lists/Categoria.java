package bibliotecadigital.lists;

public class Categoria {
	private String categoria;
	private String descripcion;
	
	public Categoria(String categoria, String descripcion) {
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
