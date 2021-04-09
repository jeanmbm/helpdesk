package br.com.unialfa.chamadostecnicos.chamado.repository;

import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface ChamadoRepository extends CrudRepository <Chamado, Long> {

    Iterable<Chamado> findByUsuario(Usuario usuario);
}
