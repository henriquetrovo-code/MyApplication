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

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(EstoqueActivity.this, AddEstoqueActivity.class);
            startActivity(intent);
        });
    }
}