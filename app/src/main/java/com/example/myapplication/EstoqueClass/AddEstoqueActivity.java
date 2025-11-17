package com.example.myapplication.EstoqueClass;

import static com.example.myapplication.EstoqueClass.Produto.nome;
import static com.example.myapplication.EstoqueClass.Produto.preco;
import static com.example.myapplication.EstoqueClass.Produto.quantidade;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.EstoqueClass.Produto;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AddEstoqueActivity extends AppCompatActivity {
    private Button btnAdicionarProduto;
    public static TextView txtProdutoEstoque, txtPreco, txtQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionarestoque);

        btnAdicionarProduto = findViewById(R.id.btnAdicionarProduto);
        txtProdutoEstoque = findViewById(R.id.txtProdutoEstoque);
        txtPreco = findViewById(R.id.txtPreco);
        txtQuantidade = findViewById(R.id.txtQuantidade);

        btnAdicionarProduto.setOnClickListener(v -> {
            Produto.AdicionarProduto();
            Intent intent = new Intent(AddEstoqueActivity.this, EstoqueActivity.class);
            startActivity(intent);
        });
    }
}