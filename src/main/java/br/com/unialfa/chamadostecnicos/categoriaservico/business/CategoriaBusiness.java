package br.com.unialfa.chamadostecnicos.categoriaservico.business;

import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import br.com.unialfa.chamadostecnicos.categoriaservico.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service public class CategoriaBusiness {

    @Autowired private CategoriaRepository categoriaRepository;

    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(long id) {
        return categoriaRepository.findById(id);
    }

    public void editarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public @ResponseBody void deletarCategoria(long id) {
        categoriaRepository.deleteById(id);
    }

}
