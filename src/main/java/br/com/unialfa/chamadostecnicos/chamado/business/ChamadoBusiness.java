package br.com.unialfa.chamadostecnicos.chamado.business;

import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.chamado.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class ChamadoBusiness {

    @Autowired private ChamadoRepository chamadoRepository;


    public void cadastrarChamado(Chamado chamado) {
        chamadoRepository.save(chamado);
    }

    public Iterable<Chamado> listarChamados(){
        return chamadoRepository.findAll();
    }

    public @ResponseBody void deletarChamado(@PathVariable(name = "id") long id) {
        chamadoRepository.deleteById(id);
    }

    public void editarStatusChamado(Chamado chamado) {
        chamadoRepository.save(chamado);
    }

}
