package bibliotecadigital.lists;

import java.time.LocalDate;

public class Autor {
	private String nombre;
	private String apellido;
    private String nacionalidad;
    private LocalDate fecha_nacimiento;
    private String biografia;

    public Autor(String nombre, String apellido, String nacionalidad, LocalDate fecha_nacimiento, String biografia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.biografia = biografia;
    }

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public String getBiografia() {
		return biografia;
	}

    
}
