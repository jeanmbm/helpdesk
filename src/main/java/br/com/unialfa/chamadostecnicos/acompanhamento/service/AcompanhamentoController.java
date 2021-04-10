package br.com.unialfa.chamadostecnicos.acompanhamento.service;

import br.com.unialfa.chamadostecnicos.acompanhamento.business.AcompanhamentoBusiness;
import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Acompanhamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoBusiness acompanhamentoBusiness;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Acompanhamento> listarAcompanhamento() {
        return acompanhamentoBusiness.listarAcompanhamentos();
    }

    @PostMapping(path = "/open")
    public void abrirAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        acompanhamentoBusiness.abrirAcompanhamento(acompanhamento);
    }

    @PutMapping(path = "/finishUser")
    public void finalizarAcompanhamentoUsuario(@RequestBody Acompanhamento acompanhamento) {
        acompanhamentoBusiness.finalizarAcompanhamentoUsuario(acompanhamento);
    }

    @PutMapping(path = "/finishTec")
    public void finalizarAcompanhamentoTecnico(@RequestBody Acompanhamento acompanhamento) {
        acompanhamentoBusiness.finalizarAcompanhamentoTecnico(acompanhamento);
    }


    /*  pra finalizar o acompanhamento por completo, é nescessario a finalização do usuario e do tecnico
     caso seja feito a requisição desse endpoint sem a finalização dos dois, dara 200, porém no "run"
     aparecerá uma mensagem de "não finalizado  */
    @PutMapping(path = "/finish")
    public void finalizarAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        acompanhamentoBusiness.finalizarAcompanhamento(acompanhamento);
    }
}
