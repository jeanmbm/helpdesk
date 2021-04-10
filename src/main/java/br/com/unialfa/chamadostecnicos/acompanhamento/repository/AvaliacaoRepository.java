package br.com.unialfa.chamadostecnicos.acompanhamento.repository;

import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Avaliacao;
import org.springframework.data.repository.CrudRepository;

public interface AvaliacaoRepository extends CrudRepository <Avaliacao, Long> {
}
