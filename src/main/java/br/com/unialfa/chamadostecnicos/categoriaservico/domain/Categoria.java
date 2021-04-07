package br.com.unialfa.chamadostecnicos.categoriaservico.domain;

import br.com.unialfa.chamadostecnicos.servico.domain.Servico;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(nullable = false, unique = true)
    private String nome;
    private String descricao;

    @OneToMany
    private List<Servico> servicos;


    public Categoria() {
    }

    public Categoria(long id, String nome, String descricao) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
