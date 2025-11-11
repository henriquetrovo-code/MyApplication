package com.example.myapplication.EstoqueClass;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AddEstoqueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionarestoque);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnAdicionarProduto = findViewById(R.id.btnAdicionarProduto);
        EditText txtProdutoEstoque = findViewById(R.id.txtProdutoEstoque);
        EditText txtQuantidade = findViewById(R.id.txtQuantidade);
        EditText txtPreco = findViewById(R.id.txtPreco);



        btnAdd.setOnClickListener(v -> {
            setContentView(R.layout.adicionarestoque);
        });
    }
}