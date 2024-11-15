package utils;

import java.util.Set;
import java.util.UUID;

import bibliotecadigital.usuarios.Usuario;

public class UsuarioUtils {
	public static Usuario buscarUsuarioPorId(Set<Usuario> usuarios, UUID usuarioId) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(usuarioId)) {
                return usuario;
            }
        }
        return null;
    }
}
