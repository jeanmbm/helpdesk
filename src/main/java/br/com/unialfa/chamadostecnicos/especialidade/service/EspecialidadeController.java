package br.com.unialfa.chamadostecnicos.especialidade.service;

import br.com.unialfa.chamadostecnicos.especialidade.business.EspecialidadeBusiness;
import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/especialidade")
public class EspecialidadeController {


    @Autowired
    private EspecialidadeBusiness especialidadeBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Especialidade> listarEspecialidade() {
        return especialidadeBusiness.listarEspecialidade();
    }

    @PostMapping(path = "/add")
    public void cadastarEspecialidade(@RequestBody Especialidade especialidade) {
        especialidadeBusiness.cadastrarEspecialidade(especialidade);
    }

    @PutMapping(path = "/edit")
    public void editarEspecialidade(@RequestBody Especialidade especialidade) {
        especialidadeBusiness.editarEspecialidade(especialidade);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarEspecialidade(@PathVariable(name = "id") long id){
        especialidadeBusiness.deletarEspecialidade(id);
    }
}
