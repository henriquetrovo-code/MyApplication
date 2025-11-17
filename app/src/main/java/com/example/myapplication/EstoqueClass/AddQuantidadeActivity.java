package com.example.myapplication.EstoqueClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.AplicativoActivity;
import com.example.myapplication.R;
import com.example.myapplication.EstoqueClass.Produto;

public class AddQuantidadeActivity extends AppCompatActivity {

    public static EditText txtMaisQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quantidade);

        Button btnAumentar = findViewById(R.id.btnAumentar);
        txtMaisQuantidade = findViewById(R.id.txtMaisQuantidade);

        btnAumentar.setOnClickListener(v -> {
            Produto.quantidadeProduto();
            Intent intent = new Intent(AddQuantidadeActivity.this, EstoqueActivity.class);
            startActivity(intent);
        });
    }
}