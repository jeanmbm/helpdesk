package br.com.unialfa.chamadostecnicos.acompanhamento.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int quantEstrelas;

    private String comentario;

    @Column(nullable = false, updatable = false)
    private LocalDate dataAvaliacao;


    public Avaliacao() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantEstrelas() {
        return quantEstrelas;
    }

    public void setQuantEstrelas(int quantEstrelas) {
        this.quantEstrelas = quantEstrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

}
