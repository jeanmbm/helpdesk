package br.com.unialfa.chamadostecnicos.servico.service;

import br.com.unialfa.chamadostecnicos.servico.business.ServicoBusiness;
import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/servico")
public class ServicoController {

    @Autowired
    private ServicoBusiness servicoBusiness;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Servico> listarServico() {
        return servicoBusiness.listarServico();
    }

    @PostMapping(path = "/add")
    public void cadastarServico(@RequestBody Servico servico) {
        servicoBusiness.cadastrarServico(servico);
    }

    @PutMapping(path = "/edit")
    public void editarServico(@RequestBody Servico servico) {
        servicoBusiness.cadastrarServico(servico);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarServico(@PathVariable(name = "id") long id){
        servicoBusiness.deletarServico(id);
    }
}
