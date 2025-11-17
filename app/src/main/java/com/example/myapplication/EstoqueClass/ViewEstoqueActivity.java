package com.example.myapplication.EstoqueClass;

import static com.example.myapplication.EstoqueClass.Produto.nome;
import static com.example.myapplication.EstoqueClass.Produto.preco;
import static com.example.myapplication.EstoqueClass.Produto.quantidade;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.EstoqueClass.Produto;


public class ViewEstoqueActivity extends AppCompatActivity {

    public TextView txtNomeProduto, txtPrecoProduto, txtQuantidadeProduto, txtTotalValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estoqueview);

        Produto Produto = new Produto(nome, preco, quantidade);

        txtNomeProduto = findViewById(R.id.txtNomeProduto);
        txtPrecoProduto = findViewById(R.id.txtPrecoProduto);
        txtQuantidadeProduto = findViewById(R.id.txtQuantidadeProduto);
        txtTotalValor = findViewById(R.id.txtTotalValor);

        txtNomeProduto.setText(String.valueOf("Nome do produto: "+Produto.nome));
        txtPrecoProduto.setText(String.valueOf("Preço do produto: "+Produto.preco));
        txtQuantidadeProduto.setText(String.valueOf("Quantidade do produto: "+Produto.quantidade));
        txtTotalValor.setText(String.valueOf("Valor total: "+Produto.valorTotalStock()));



    }
}