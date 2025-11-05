package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConversorActivity extends AppCompatActivity {

    TextView txtResultado;
    EditText txtValor;
    Button btnConversor;
    Spinner spMoeda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);

        final double taxaDolar = 0.20;
        final double taxaEuro = 0.18;

        String[] moedas = {"Dólar", "Euro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, moedas
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        txtValor = findViewById(R.id.txtValor);
        txtResultado = findViewById(R.id.txtResultado);
        btnConversor = findViewById(R.id.btnConverter);
        spMoeda = findViewById(R.id.spTemperatura);

        spMoeda.setAdapter(adapter);

        btnConversor.setOnClickListener(v -> {
            String valorStr = txtValor.getText().toString();
            if(valorStr.isEmpty()) {
                Toast.makeText(ConversorActivity.this, "Digite um valor em reais", Toast.LENGTH_SHORT).show();
                return;
            }
            double valorReal = Double.parseDouble(valorStr);
            double resultado = 0;
            String moeda = spMoeda.getSelectedItem().toString();

            if(moeda.equals("Dólar")){
                resultado = valorReal / taxaDolar;
            }else if(moeda.equals("Euro")){
                resultado = valorReal / taxaEuro;
            }
            txtResultado.setText(String.format("Valor convertido: %.2f %s", resultado, moeda));
        });
    }
}
