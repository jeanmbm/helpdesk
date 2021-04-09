package br.com.unialfa.chamadostecnicos.servico.domain;

public enum Area {

    SOFTWARE("Software"), HARDWARE("Hardware");

    Area(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;
    public String getDescricao() {
        return descricao;
    }
}
