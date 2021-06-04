package br.com.unialfa.chamadostecnicos.servico.business;

import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import br.com.unialfa.chamadostecnicos.servico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class ServicoBusiness {

    @Autowired
    private ServicoRepository servicoRepository;

    public void cadastrarServico(Servico servico) {
        servicoRepository.save(servico);
    }

    public Iterable<Servico> listarServico() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarServicoPorId(long id) {
        return servicoRepository.findById(id);
    }

    public void editarServico(Servico servico) {
        servicoRepository.save(servico);
    }

    public @ResponseBody void deletarServico(long id) {
        servicoRepository.deleteById(id);
    }
}
