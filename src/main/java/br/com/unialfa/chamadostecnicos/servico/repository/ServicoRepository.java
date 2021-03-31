package br.com.unialfa.chamadostecnicos.servico.repository;

import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import org.springframework.data.repository.CrudRepository;

public interface ServicoRepository extends CrudRepository <Servico, Long> {

}
