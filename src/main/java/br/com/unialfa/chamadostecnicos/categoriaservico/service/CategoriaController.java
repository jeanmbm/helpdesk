package br.com.unialfa.chamadostecnicos.categoriaservico.service;

import br.com.unialfa.chamadostecnicos.categoriaservico.business.CategoriaBusiness;
import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaBusiness categoriaBusiness;

    @PostMapping(path = "/add")
    public ResponseEntity<?> cadastarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaBusiness.cadastrarCategoria(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Categoria> listarCategoria() {
        return categoriaBusiness.listarCategoria();
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
