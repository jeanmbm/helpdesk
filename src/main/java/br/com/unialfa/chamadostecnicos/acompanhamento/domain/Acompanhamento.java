package br.com.unialfa.chamadostecnicos.acompanhamento.domain;

import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Acompanhamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean finalizadoUsuario;
    private boolean finalizadoTecnico;

    @ManyToOne
    private Usuario tecnico;

    @OneToOne
    private Chamado chamado;

    @OneToOne
    private Avaliacao avaliacao;


    public Acompanhamento() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFinalizadoUsuario() {
        return finalizadoUsuario;
    }

    public void setFinalizadoUsuario(boolean finalizadoUsuario) {
        this.finalizadoUsuario = finalizadoUsuario;
    }

    public boolean isFinalizadoTecnico() {
        return finalizadoTecnico;
    }

    public void setFinalizadoTecnico(boolean finalizadoTecnico) {
        this.finalizadoTecnico = finalizadoTecnico;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public Object setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
        return null;
    }
}
