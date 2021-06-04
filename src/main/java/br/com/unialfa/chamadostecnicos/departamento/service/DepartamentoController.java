package br.com.unialfa.chamadostecnicos.departamento.service;

import br.com.unialfa.chamadostecnicos.departamento.business.DepartamentoBusiness;
import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoBusiness departamentoBusiness;


    @PostMapping(path = "/add")
    public ResponseEntity<?> cadastarDepartamento(@RequestBody Departamento departamento) {
        try {
            departamentoBusiness.cadastrarDepartamento(departamento);
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Departamento> listarDepartamento() {
        return departamentoBusiness.listarDepartamento();
    }

    @GetMapping(path = "/{idDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Departamento> buscarDepartamentoPorId(@PathVariable (name = "idDepartamento") long id) {
        return departamentoBusiness.buscarDepartamentoPorId(id);
    }

    @PutMapping(path = "/edit")
    public void editarDepartamento(@RequestBody Departamento departamento) {
        departamentoBusiness.editarDepartamento(departamento);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarDepartamento(@PathVariable(name = "id") long id){
        departamentoBusiness.deletarDepartamento(id);
    }
}
