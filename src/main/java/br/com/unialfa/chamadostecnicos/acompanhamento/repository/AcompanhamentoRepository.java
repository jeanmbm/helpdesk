package br.com.unialfa.chamadostecnicos.acompanhamento.repository;

import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Acompanhamento;
import org.springframework.data.repository.CrudRepository;

public interface AcompanhamentoRepository extends CrudRepository <Acompanhamento, Long> {
}
