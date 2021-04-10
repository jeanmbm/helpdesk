package br.com.unialfa.chamadostecnicos.acompanhamento.business;

import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Acompanhamento;
import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Avaliacao;
import br.com.unialfa.chamadostecnicos.acompanhamento.repository.AcompanhamentoRepository;
import br.com.unialfa.chamadostecnicos.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AcompanhamentoBusiness {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    private AvaliacaoBusiness avaliacaoBusiness;

    public Iterable<Acompanhamento> listarAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }

    public void abrirAcompanhamento(Acompanhamento acompanhamento) {
        if (acompanhamento.getTecnico().isTecnico()) {
            acompanhamento.getChamado().setStatus(Status.ANDAMENTO);
            acompanhamentoRepository.save(acompanhamento);
        } else {
            System.err.println("!! Usuario que vai atender não é tecnico !!");
        }
    }

    public void finalizarAcompanhamentoUsuario(Acompanhamento acompanhamento) {
        acompanhamento.setFinalizadoUsuario(true);
        acompanhamentoRepository.save(acompanhamento);
    }

    public void finalizarAcompanhamentoTecnico(Acompanhamento acompanhamento) {
        acompanhamento.setFinalizadoTecnico(true);
        acompanhamentoRepository.save(acompanhamento);
    }

    public void finalizarAcompanhamento(Acompanhamento acompanhamento) {
        if (acompanhamento.isFinalizadoTecnico() && acompanhamento.isFinalizadoUsuario()) {
            acompanhamento.getChamado().setDataSolucao(LocalDate.now());
            acompanhamento.getChamado().setStatus(Status.CONCLUIDO);
            Avaliacao avaliacao = new Avaliacao();
            avaliacaoBusiness.fazerAvaliacao(acompanhamento, avaliacao);
            acompanhamentoRepository.save(acompanhamento);
        } else {
            if (!acompanhamento.isFinalizadoTecnico()) {
                System.err.println("!! O tecnico não finalizou o acompanhamento !!");
            } else {
                System.err.println("!! O usuários não finalizou o acompanhamento !!");
            }
        }
    }
}
