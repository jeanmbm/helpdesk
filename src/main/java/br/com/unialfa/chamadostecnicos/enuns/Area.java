package br.com.unialfa.chamadostecnicos.enuns;

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
