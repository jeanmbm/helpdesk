package br.com.unialfa.chamadostecnicos.chamado.service;

import br.com.unialfa.chamadostecnicos.chamado.business.ChamadoBusiness;
import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/chamado")
public class ChamadoController {

    @Autowired private ChamadoBusiness chamadoBusiness;


    @PostMapping(path = "/abrir")
    public void abrirChamado(@RequestBody Chamado chamado) {
        chamadoBusiness.cadastrarChamado(chamado);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Chamado> listarChamados() {
        return chamadoBusiness.listarChamados();
    }

    @GetMapping(path = "/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Chamado> listarChamadosPorUsuario(@PathVariable Long idUsuario) {
        return chamadoBusiness.listarChamadosPorUsuario(idUsuario);
    }

    @PutMapping(path = "/edit-status")
    public void editarChamado(@RequestBody Chamado chamado) {
        chamadoBusiness.editarStatusChamado(chamado);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarChamado(@PathVariable(name = "id") long id){
        chamadoBusiness.deletarChamado(id);
    }

}
