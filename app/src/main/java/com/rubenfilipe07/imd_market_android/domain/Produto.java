package com.rubenfilipe07.imd_market_android.domain;

public class Produto {

    private String codigo_produto;
    private String nome_produto;
    private String descricao_produto;
    private int estoque;

    public String getCodigoProduto() {
        return codigo_produto;
    }

    public void setCodigoProduto(String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNomeProduto() {
        return nome_produto;
    }

    public void setNomeProduto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricaoProduto() {
        return descricao_produto;
    }

    public void setDescricaoProduto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}