package recomendaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bibliotecadigital.Biblioteca;
import bibliotecadigital.interfaces.SistemaRecomendaciones;
import bibliotecadigital.recursos.Prestamo;
import bibliotecadigital.recursos.RecursoMultimedia;
import bibliotecadigital.usuarios.Usuario;
import utils.CalcularPromedioReseñas;

public class RecomendacionesPorHistorial implements SistemaRecomendaciones {

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<RecursoMultimedia> obtenerRecomendaciones(Biblioteca biblioteca, Usuario usuario) {
		// 1. Verificar si el usuario se encuentra en la biblioteca
		Usuario usuarioEncontrado = null;
		for(Usuario usuarioBuscado : biblioteca.getUsuarios()) {
			if(usuarioBuscado.equals(usuario)) {
				usuarioEncontrado = usuarioBuscado;
				break;
			}
		}
		
		if(usuarioEncontrado == null) {
			System.out.println("No se ha podido encontrar el usuario en la biblitoeca");
			return null;
		}
		
		// 2. Buscamos los prestamos del usuario
		List<Prestamo> historial = usuario.getPrestamos();
		List<RecursoMultimedia> recomendaciones = new ArrayList<>();
		if(historial.isEmpty()) {
			System.out.println("El usuario no tiene prestamos por ende no podemos recomendar..");
			return null;
		}
		
		// 3. Recomendamos en base al historial
		for(Prestamo prestamo : historial) {
			for(RecursoMultimedia recurso : biblioteca.getRecursos_multimedias()) {
				if(!historial.contains(recurso) && recurso.getCategoria().equals(prestamo.getRecurso().getCategoria())) {
					recomendaciones.add(recurso);
				}
			}
		}
		return recomendaciones;
	}

}
