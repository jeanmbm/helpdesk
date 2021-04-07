package br.com.unialfa.chamadostecnicos.chamado.domain;

public enum Status {

    ANALISE("Em análise"), ABERTO("Em aberto"), ANDAMENTO("Em andamento"), CONCLUIDO("Concluído"), CANCELADO("Cancelado");

    Status(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;
    public String getDescricao() {
        return descricao;
    }

}
