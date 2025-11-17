package com.example.myapplication.EstoqueClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.AplicativoActivity;
import com.example.myapplication.R;

public class EstoqueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estoque);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnView = findViewById(R.id.btnView);
        Button btnAddQuantidade = findViewById(R.id.btnAddQuantidade);
        Button btnRemoverQuantidade = findViewById(R.id.btnRemoverQuantidade);


        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(EstoqueActivity.this, AddEstoqueActivity.class);
            startActivity(intent);
        });

        btnView.setOnClickListener(v -> {
            Intent intent = new Intent(EstoqueActivity.this, ViewEstoqueActivity.class);
            startActivity(intent);
        });

        btnAddQuantidade.setOnClickListener(v -> {
            Intent intent = new Intent(EstoqueActivity.this, AddQuantidadeActivity.class);
            startActivity(intent);
        });

        btnRemoverQuantidade.setOnClickListener(v -> {
            Intent intent = new Intent(EstoqueActivity.this, RemoverQuantidadeActivity.class);
            startActivity(intent);
        });
    }
}