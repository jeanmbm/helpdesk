package br.com.unialfa.chamadostecnicos.chamado.business;

import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.chamado.repository.ChamadoRepository;
import br.com.unialfa.chamadostecnicos.servico.domain.Prioridade;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class ChamadoBusiness {

    @Autowired private ChamadoRepository chamadoRepository;


    public void cadastrarChamado(Chamado chamado) {
        if (chamado.getServico().getPrioridade() == Prioridade.BAIXA) {
            chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(14));
        } else if (chamado.getServico().getPrioridade() == Prioridade.MEDIA) {
            chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(10));
        } else if (chamado.getServico().getPrioridade() == Prioridade.ALTA) {
            chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(5));
        } else {
            chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(2));
        }
        chamadoRepository.save(chamado);
    }

    public Iterable<Chamado> listarChamados(){
        return chamadoRepository.findAll();
    }

    public Iterable<Chamado> listarChamadosPorUsuario(long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return chamadoRepository.findByUsuario(usuario);
    }

    public @ResponseBody void deletarChamado(@PathVariable(name = "id") long id) {
        chamadoRepository.deleteById(id);
    }

    public void editarStatusChamado(Chamado chamado) {
        chamadoRepository.save(chamado);
    }

}
