package br.com.unialfa.chamadostecnicos.categoriaservico.service;

import br.com.unialfa.chamadostecnicos.categoriaservico.business.CategoriaBusiness;
import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaBusiness categoriaBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Categoria> listarCLiente() {
        return categoriaBusiness.listarCategoria();
    }

    @PostMapping(path = "/add")
    public void cadastarCategoria(@RequestBody Categoria categoria) {
        categoriaBusiness.cadastrarCategoria(categoria);
    }

    @PutMapping(path = "/edit")
    public void editarCategoria(@RequestBody Categoria categoria) {
        categoriaBusiness.editarCategoria(categoria);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCategoria(@PathVariable(name = "id") long id){
        categoriaBusiness.deletarCategoria(id);
    }

}
