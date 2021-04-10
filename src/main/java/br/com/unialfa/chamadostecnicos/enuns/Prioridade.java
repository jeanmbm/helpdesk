package br.com.unialfa.chamadostecnicos.enuns;

public enum Prioridade {

    BAIXA("Baixa"), MEDIA("Média"), ALTA("Alta"), URGENTE("Urgente");

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;
    public String getDescricao() {
        return descricao;
    }

}
