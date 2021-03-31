package br.com.unialfa.chamadostecnicos.categoriaservico.repository;

import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository <Categoria, Long> {
}
