package br.com.unialfa.chamadostecnicos.especialidade.service;

import br.com.unialfa.chamadostecnicos.especialidade.business.EspecialidadeBusiness;
import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/especialidade")
public class EspecialidadeController {


    @Autowired
    private EspecialidadeBusiness especialidadeBusiness;

    @PostMapping(path = "/add")
    public ResponseEntity<?> cadastarEspecialidade(@RequestBody Especialidade especialidade) {
        try {
            especialidadeBusiness.cadastrarEspecialidade(especialidade);
            return new ResponseEntity<>(especialidade, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Especialidade> listarEspecialidade() {
        return especialidadeBusiness.listarEspecialidade();
    }

    @GetMapping(path = "/{idEspecialidade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Especialidade> buscarEspecialidadePorId(@PathVariable (name = "idEspecialidade") long id) {
        return especialidadeBusiness.buscarEspecialidadePorId(id);
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
