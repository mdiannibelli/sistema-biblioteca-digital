package bibliotecadigital.lists;

public class Genero {
	private String genero;
	private String descripcion;
	
	public Genero(String genero, String descripcion) {
		this.genero = genero;
		this.descripcion = descripcion;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
