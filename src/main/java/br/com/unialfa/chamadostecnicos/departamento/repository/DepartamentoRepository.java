package br.com.unialfa.chamadostecnicos.departamento.repository;

import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository <Departamento, Long> {
}
