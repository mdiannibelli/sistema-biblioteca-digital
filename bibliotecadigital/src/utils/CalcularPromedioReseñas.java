package utils;

import java.util.List;

import bibliotecadigital.lists.Reseña;

public class CalcularPromedioReseñas {
	public static double calcularPromedio(List<Reseña> reseñas) {
		return reseñas.stream()
				.mapToDouble(Reseña::getCalificacion)
				.average()
				.orElse(0.0);
	}
}
