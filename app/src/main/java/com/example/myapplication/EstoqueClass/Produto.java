package com.example.myapplication.EstoqueClass;
import com.example.myapplication.EstoqueClass.AddEstoqueActivity;
import com.example.myapplication.EstoqueClass.AddQuantidadeActivity;

public class Produto {
    public static String nome;
    public static float preco;
    public static int quantidade;

    public Produto(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public float valorTotalStock() {
        return preco * quantidade;
    }

    public static void quantidadeProduto() {
        int adicionar = Integer.parseInt(AddQuantidadeActivity.txtMaisQuantidade.getText().toString());
        quantidade += adicionar;
    }

    public static void removerQuantidade() {
        int remover = Integer.parseInt(RemoverQuantidadeActivity.txtMenosQuantidade.getText().toString());
        quantidade -= remover;
    }
    public static void AdicionarProduto(){
        nome = AddEstoqueActivity.txtProdutoEstoque.getText().toString();
        preco = Float.parseFloat(AddEstoqueActivity.txtPreco.getText().toString());
        quantidade = Integer.parseInt(AddEstoqueActivity.txtQuantidade.getText().toString());
    }

    public static void AdicionarQuantidade(){
        quantidade = Integer.parseInt(AddEstoqueActivity.txtQuantidade.getText().toString());
    }
}