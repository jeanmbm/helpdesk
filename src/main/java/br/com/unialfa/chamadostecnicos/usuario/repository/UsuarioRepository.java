package br.com.unialfa.chamadostecnicos.usuario.repository;

import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
}
