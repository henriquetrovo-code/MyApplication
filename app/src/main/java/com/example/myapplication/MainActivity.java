package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referenciando os elementos da interface
        TextView txtUsuario = findViewById(R.id.txtUsuario);
        TextView txtSenha = findViewById(R.id.txtSenha);
        Button btnEntrar = findViewById(R.id.btnEntrar);

        // Ação de clique no botão
        btnEntrar.setOnClickListener(v -> {
            String usuario = txtUsuario.getText().toString();
            String senha = txtSenha.getText().toString();

            if ("Henrique".equals(usuario) && "Senai".equals(senha)) {
                Intent intent = new Intent(MainActivity.this, AplicativoActivity.class);
                startActivity(intent);
            } else {
                txtUsuario.setText("Usuário ou senha incorretos");
                txtSenha.setText("");
            }
        });
    }
}