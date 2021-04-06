package br.com.unialfa.chamadostecnicos.departamento.domain;


import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String nome;
    private String descricao;

    @OneToMany
    private List<Usuario> usuarios;


    public Departamento() {
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
}
