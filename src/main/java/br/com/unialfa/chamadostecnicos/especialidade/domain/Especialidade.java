package br.com.unialfa.chamadostecnicos.especialidade.domain;

import br.com.unialfa.chamadostecnicos.enuns.Area;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity public class Especialidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(unique = true, nullable = false)
    private String nome;
    private String descricao;

    @Column(nullable = false)
    private Area area;

    @OneToMany
    private List<Usuario> usuarios;


    public Especialidade() {
    }

    public Especialidade(long id, String nome, String descricao, List<Usuario> usuarios) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuarios = usuarios;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
