package com.rubenfilipe07.imd_market_android.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Produto implements Parcelable {

    private String codigo_produto;
    private String nome_produto;
    private String descricao_produto;
    private int estoque;

    public Produto() {}

    public Produto(String nomeProduto) {
        this.nome_produto = nomeProduto;
    }

    public Produto(String codigo_produto, String nome_produto, String descricao_produto, int estoque) {
        this.codigo_produto = codigo_produto;
        this.nome_produto = nome_produto;
        this.descricao_produto = descricao_produto;
        this.estoque = estoque;
    }

    protected Produto(Parcel in) {
        codigo_produto = in.readString();
        nome_produto = in.readString();
        descricao_produto = in.readString();
        estoque = in.readInt();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(codigo_produto);
        parcel.writeString(nome_produto);
        parcel.writeString(descricao_produto);
        parcel.writeInt(estoque);
    }

    @NonNull
    @Override
    public String toString() {
       String produtoStr = String.format("Código: %s \nNome: %s \nDescrição: %s \nEstoque: %d", codigo_produto,
               nome_produto, descricao_produto, estoque);
       return produtoStr;
    }
}
