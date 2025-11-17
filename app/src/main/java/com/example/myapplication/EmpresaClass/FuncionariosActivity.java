package com.example.myapplication.EmpresaClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class FuncionariosActivity extends AppCompatActivity {

    public Button btnFuncionarioBase, btnGerente, btnEstagiario, btnDesenvolvedor;
    public static TextView txtFuncionarioBase, txtGerente, txtEstagiario, txtDesenvolvedor;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Funcionario.FuncionarioBase();
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            Gerente.Gerente();
        }
        else if (requestCode == 3 && resultCode == RESULT_OK) {
            Desenvolvedor.Desenvolvedor();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funcionarios);

        btnFuncionarioBase = findViewById(R.id.btnFuncionarioBase);
        txtFuncionarioBase = findViewById(R.id.txtFuncionarioBase);
        txtGerente = findViewById(R.id.txtGerente);
        txtEstagiario = findViewById(R.id.txtEstagiario);
        txtDesenvolvedor = findViewById(R.id.txtDesenvolvedor);
        btnGerente = findViewById(R.id.btnGerente);
        btnEstagiario = findViewById(R.id.btnEstagiario);
        btnDesenvolvedor = findViewById(R.id.btnDesenvolvedor);

        btnFuncionarioBase.setOnClickListener(v -> {
            Intent intent = new Intent(FuncionariosActivity.this, SalarioBaseActivity.class);
            startActivityForResult(intent, 1);
        });
        btnGerente.setOnClickListener(v -> {
            Intent intent = new Intent(FuncionariosActivity.this, BonusGerenteActivity.class);
            startActivityForResult(intent, 2);
        });

        btnDesenvolvedor.setOnClickListener(v -> {
            Intent intent = new Intent(FuncionariosActivity.this, HorasExtrasActivity.class);
            startActivityForResult(intent, 3);
        });
        btnEstagiario.setOnClickListener(v ->
                Estagiario.Estagiario()
        );
    }
}