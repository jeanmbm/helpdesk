package br.com.unialfa.chamadostecnicos.especialidade.repository;

import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;
import org.springframework.data.repository.CrudRepository;

public interface EspecialidadeRepository extends CrudRepository <Especialidade, Long> {
}
