package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AplicativoActivity extends AppCompatActivity {
    Button btnFrases, btnConverter, btnTemperatura, btnCep, btnPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicativo);

        btnConverter = findViewById(R.id.btnConverter);
        btnFrases = findViewById(R.id.btnFrases);
        btnTemperatura = findViewById(R.id.btnTemperatura);
        btnCep = findViewById(R.id.btnCep);
        btnPet = findViewById(R.id.btnPet);

        btnFrases.setOnClickListener(v -> {
        Intent intent = new Intent(AplicativoActivity.this, HomeActivity.class);
        startActivity(intent);
        });

        btnConverter.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, ConversorActivity.class);
            startActivity(intent);
        });

        btnTemperatura.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, TemperaturaActivity.class);
            startActivity(intent);
        });

        btnCep.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, CepActivity.class);
            startActivity(intent);
        });

        btnPet.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, PetActivity.class);
            startActivity(intent);
        });
    }
}