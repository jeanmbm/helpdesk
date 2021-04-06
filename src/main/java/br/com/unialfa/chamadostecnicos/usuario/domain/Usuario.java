package br.com.unialfa.chamadostecnicos.usuario.domain;

import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;

import javax.persistence.*;
import java.io.Serializable;


@Entity public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String telefone;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;
    private String senha;

    @ManyToOne
    private Departamento departamento;

    private boolean tecnico;

    @ManyToOne
    private Especialidade especialidade;


    public Usuario() {
    }

    public Usuario(long id, String nome, String telefone, String cpf, String email, String senha, Departamento departamento, boolean tecnico, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
        this.tecnico = tecnico;
        this.especialidade = especialidade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public boolean isTecnico() {
        return tecnico;
    }

    public void setTecnico(boolean tecnico) {
        this.tecnico = tecnico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
