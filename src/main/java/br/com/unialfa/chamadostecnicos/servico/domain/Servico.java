package br.com.unialfa.chamadostecnicos.servico.domain;

import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.enuns.Area;
import br.com.unialfa.chamadostecnicos.enuns.Prioridade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Prioridade prioridade;

    @Column(nullable = false)
    private Area area;

    @ManyToOne
    private Categoria categoria;

    @OneToMany
    private List<Chamado> chamados;


    public Servico() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
