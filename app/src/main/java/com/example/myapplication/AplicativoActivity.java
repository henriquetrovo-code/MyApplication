package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AplicativoActivity extends AppCompatActivity {
    Button btnFrases, btnConverter, btnTemperatura, btnCep, btnPet, btnCompras, btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicativo);

        // Inicializando TODOS os botões
        btnConverter = findViewById(R.id.btnConverter);
        btnFrases = findViewById(R.id.btnFrases);
        btnTemperatura = findViewById(R.id.btnTemperatura);
        btnCep = findViewById(R.id.btnCep);
        btnPet = findViewById(R.id.btnPet);

        // --- ADICIONE ESTAS DUAS LINHAS ---
        // Certifique-se que o seu XML `aplicativo.xml` tem botões com os IDs `R.id.btnCompras` e `R.id.btnCamera`
        btnCompras = findViewById(R.id.btnCompras);
        btnCamera = findViewById(R.id.btnCamera);
        // ------------------------------------

        // Agora o código abaixo vai funcionar, pois os botões não são mais nulos.

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
    }
}
