package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.EmpresaClass.FuncionariosActivity;
import com.example.myapplication.EstoqueClass.EstoqueActivity;
import com.example.myapplication.SalarioClass.SalarioActivity;

public class AplicativoActivity extends AppCompatActivity {
    Button btnFrases, btnConverter, btnTemperatura, btnCep, btnPet, btnCompras, btnCamera, btnSalario, btnEstoque, btnEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicativo);

        btnConverter = findViewById(R.id.btnConverter);
        btnFrases = findViewById(R.id.btnFrases);
        btnTemperatura = findViewById(R.id.btnTemperatura);
        btnCep = findViewById(R.id.btnCep);
        btnPet = findViewById(R.id.btnPet);
        btnCompras = findViewById(R.id.btnCompras);
        btnCamera = findViewById(R.id.btnCamera);
        btnSalario = findViewById(R.id.btnSalario);
        btnEstoque = findViewById(R.id.btnEstoque);
        btnEmpresa = findViewById(R.id.btnEmpresa);

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

        btnCompras.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, ComprasActivity.class);
            startActivity(intent);
        });

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, CameraActivity.class);
            startActivity(intent);
        });

        btnSalario.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, SalarioActivity.class);
            startActivity(intent);
        });

        btnEstoque.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, EstoqueActivity.class);
            startActivity(intent);
        });

        btnEmpresa.setOnClickListener(v -> {
            Intent intent = new Intent(AplicativoActivity.this, FuncionariosActivity.class);
            startActivity(intent);
        });
    }
}