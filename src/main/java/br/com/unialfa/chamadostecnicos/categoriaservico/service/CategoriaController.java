package br.com.unialfa.chamadostecnicos.categoriaservico.service;

import br.com.unialfa.chamadostecnicos.categoriaservico.business.CategoriaBusiness;
import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @GetMapping(path = "/{idCategoria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Categoria> buscarCategoriaPorId(@PathVariable (name = "idCategoria") long id) {
        return categoriaBusiness.buscarCategoriaPorId(id);
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
