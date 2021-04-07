package br.com.unialfa.chamadostecnicos.chamado.service;

import br.com.unialfa.chamadostecnicos.chamado.business.ChamadoBusiness;
import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.chamado.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/chamado")
public class ChamadoController {

    @Autowired private ChamadoBusiness chamadoBusiness;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Chamado> listarChamados() {
        return chamadoBusiness.listarChamados();
    }

    @PostMapping(path = "/abrir")
    public void abrirChamado(@RequestBody Chamado chamado) {
        chamadoBusiness.cadastrarChamado(chamado);
    }

    @PutMapping(path = "/edit")
    public void editarChamado(@RequestBody Chamado chamado) {
        chamadoBusiness.editarStatusChamado(chamado);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarChamado(@PathVariable(name = "id") long id){
        chamadoBusiness.deletarChamado(id);
    }

}

//    @GetMapping(path = "/{idUsuario}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Chamado> listarChamado(@PathVariable Long idUsuario) {
//        Chamado chamado = new Chamado();
//        chamado.setId(idUsuario);
//        return chamadoRepository.findByChamado(chamado);
//    }

//    @PutMapping(path = "/mudar-satus")
//    public void mudarStatusChamado(Chamado chamado) {
//        chamadoBusiness.editarStatusChamado(chamado);
//    }
