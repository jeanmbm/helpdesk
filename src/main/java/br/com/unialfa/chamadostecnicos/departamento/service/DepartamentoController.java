package br.com.unialfa.chamadostecnicos.departamento.service;

import br.com.unialfa.chamadostecnicos.departamento.business.DepartamentoBusiness;
import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/departamento")
public class DepartamentoController {


    @Autowired
    private DepartamentoBusiness departamentoBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Departamento> listarDepartamento() {
        return departamentoBusiness.listarDepartamento();
    }

    @PostMapping(path = "/add")
    public void cadastarDepartamento(@RequestBody Departamento departamento) {
        departamentoBusiness.cadastrarDepartamento(departamento);
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
