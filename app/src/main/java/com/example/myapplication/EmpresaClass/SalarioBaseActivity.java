package com.example.myapplication.EmpresaClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SalarioBaseActivity extends AppCompatActivity {

    public Button btnReceberSalario;
    public static EditText txtReceberSalarioBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receber_salario_base);

        btnReceberSalario = findViewById(R.id.btnReceberSalario);
        txtReceberSalarioBase = findViewById(R.id.txtReceberSalarioBase);

        btnReceberSalario.setOnClickListener(v -> {
            Funcionario.receber_salario();
            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent); // devolve o resultado
            finish(); // fecha e volta para FuncionariosActivity
        });

    }
}