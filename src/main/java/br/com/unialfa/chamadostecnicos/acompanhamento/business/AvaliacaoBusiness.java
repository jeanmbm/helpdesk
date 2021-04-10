package br.com.unialfa.chamadostecnicos.acompanhamento.business;

import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Acompanhamento;
import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Avaliacao;
import br.com.unialfa.chamadostecnicos.acompanhamento.repository.AcompanhamentoRepository;
import br.com.unialfa.chamadostecnicos.acompanhamento.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoBusiness {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public void fazerAvaliacao(Acompanhamento acompanhamento, Avaliacao avaliacao) {
        if (acompanhamento.getAvaliacao().getQuantEstrelas() > 5) {
            System.err.println("!! A quantidade de estrelas só vai até !!");
        } else {
            acompanhamento.setAvaliacao(avaliacao);
            avaliacaoRepository.save(avaliacao);
            acompanhamentoRepository.save(acompanhamento);
        }

    }

}
