package utils;

import java.util.List;
import java.util.UUID;

import bibliotecadigital.recursos.RecursoMultimedia;

public class RecursoUtils {
	public static RecursoMultimedia buscarRecursoPorId(List<RecursoMultimedia> recursos, UUID recursoId) {
        for (RecursoMultimedia recurso : recursos) {
            if (recurso.getUuid().equals(recursoId)) {
                return recurso;
            }
        }
        return null;
    }
}
