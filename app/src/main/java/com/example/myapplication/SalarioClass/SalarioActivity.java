package com.example.myapplication.SalarioClass;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class SalarioActivity extends AppCompatActivity {

    EditText txtNome,txtSalario,txtImposto,txtPercentual;
    TextView txtFuncionario,txtAtualizado;
    Button btnEnter,btnEnter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salario);

        txtNome = findViewById(R.id.txtNome);
        txtSalario = findViewById(R.id.txtSalario);
        txtImposto = findViewById(R.id.txtImposto);
        txtFuncionario = findViewById(R.id.txtFuncionario);
        txtAtualizado = findViewById(R.id.txtAtualizado);
        txtPercentual = findViewById(R.id.txtPercentual);
        btnEnter = findViewById(R.id.btnEnter);
        btnEnter2 = findViewById(R.id.btnEnter2);

        btnEnter.setOnClickListener(v -> {
            SalarioLiquido();
        });

        btnEnter2.setOnClickListener(v -> {
            SalarioAumento();
        });
    }
    public void SalarioLiquido(){
        Funcionario obj = new Funcionario();
        obj.nome = txtNome.getText().toString();
        obj.salario = Double.parseDouble(txtSalario.getText().toString());
        obj.imposto = Double.parseDouble(txtImposto.getText().toString());
        obj.salarioLiquido = obj.salario - obj.imposto;
        txtFuncionario.setText("Funcionário: " + obj.nome + ", R$ " + obj.salarioLiquido);
    }
    public void SalarioAumento(){
        Funcionario obj = new Funcionario();
        obj.nome = txtNome.getText().toString();
        obj.salario = Double.parseDouble(txtSalario.getText().toString());
        obj.imposto = Double.parseDouble(txtImposto.getText().toString());
        obj.salarioLiquido = obj.salario - obj.imposto;
        obj.salarioAumento = obj.salarioLiquido + (obj.salario * (Double.parseDouble(txtPercentual.getText().toString()) / 100));
        txtAtualizado.setText("Dados atualizados: " + obj.nome + ", R$ " + obj.salarioAumento);
    };

}