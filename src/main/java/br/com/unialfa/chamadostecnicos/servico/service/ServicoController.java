package br.com.unialfa.chamadostecnicos.servico.service;

import br.com.unialfa.chamadostecnicos.servico.business.ServicoBusiness;
import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/servico")
public class ServicoController {

    @Autowired
    private ServicoBusiness servicoBusiness;

    @PostMapping(path = "/add")
    public void cadastarServico(@RequestBody Servico servico) {
        servicoBusiness.cadastrarServico(servico);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Servico> listarServico() {
        return servicoBusiness.listarServico();
    }

    @GetMapping(path = "/{idServico}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Servico> buscarServicoPorId(@PathVariable (name = "idServico") long id) {
        return servicoBusiness.buscarServicoPorId(id);
    }

    @PutMapping(path = "/edit")
    public void editarServico(@RequestBody Servico servico) {
        servicoBusiness.editarServico(servico);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarServico(@PathVariable(name = "id") long id){
        servicoBusiness.deletarServico(id);
    }
}
