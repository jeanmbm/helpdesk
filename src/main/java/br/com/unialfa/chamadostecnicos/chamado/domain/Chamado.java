package br.com.unialfa.chamadostecnicos.chamado.domain;


import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class Chamado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, updatable = false)
    private LocalDate dataAbertura;

    @Column(nullable = false, updatable = false)
    private LocalDate prazoSolucao;

    @Column(nullable = false, updatable = false)
    private LocalDate dataSolucao;

    @Column(nullable = false)
    private Status status;

    @Column(updatable = false)
    private String mensagem;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Servico servico;


    public Chamado() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getPrazoSolucao() {
        return prazoSolucao;
    }

    public void setPrazoSolucao(LocalDate prazoSolucao) {
        this.prazoSolucao = prazoSolucao;
    }

    public LocalDate getDataSolucao() {
        return dataSolucao;
    }

    public void setDataSolucao(LocalDate dataSolucao) {
        this.dataSolucao = dataSolucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
