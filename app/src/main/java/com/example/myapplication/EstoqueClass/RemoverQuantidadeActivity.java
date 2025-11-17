package com.example.myapplication.EstoqueClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.AplicativoActivity;
import com.example.myapplication.R;
import com.example.myapplication.EstoqueClass.Produto;

public class RemoverQuantidadeActivity extends AppCompatActivity {

    public static EditText txtMenosQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quantidadereduzir);

        Button btnDiminuir = findViewById(R.id.btnDiminuir);
        txtMenosQuantidade = findViewById(R.id.txtMenosQuantidade);

        btnDiminuir.setOnClickListener(v -> {
            Produto.removerQuantidade();
            Intent intent = new Intent(RemoverQuantidadeActivity.this, EstoqueActivity.class);
            startActivity(intent);
        });
    }
}