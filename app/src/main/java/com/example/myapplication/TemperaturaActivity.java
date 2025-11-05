package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperaturaActivity extends AppCompatActivity {

    TextView txtResultado;
    EditText txtValor;
    Button btnConversor;
    Spinner spTemperatura, spTemperatura2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperatura);

        final double taxaFahrenheit = 1.8;
        final double taxaKevin = 273.15;

        String[] temperaturas = {"Fahrenheit", "Kelvin", "Celsius"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, temperaturas
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        txtValor = findViewById(R.id.txtValor);
        txtResultado = findViewById(R.id.txtResultado);
        btnConversor = findViewById(R.id.btnConverter);
        spTemperatura = findViewById(R.id.spTemperatura);
        spTemperatura2 = findViewById(R.id.spTemperatura2);

        spTemperatura.setAdapter(adapter);
        spTemperatura2.setAdapter(adapter);

        btnConversor.setOnClickListener(v -> {
            String valorStr = txtValor.getText().toString();
            if(valorStr.isEmpty()) {
                Toast.makeText(TemperaturaActivity.this, "Digite uma temperatura em celsius", Toast.LENGTH_SHORT).show();
                return;
            }
            double valorTemperatura = Double.parseDouble(valorStr);
            double resultado = 0;
            String temperatura = spTemperatura.getSelectedItem().toString();
            String temperatura2 = spTemperatura2.getSelectedItem().toString();

            if(temperatura.equals("Celsius")){
                if(temperatura2.equals("Fahrenheit")) {
                    resultado = valorTemperatura * taxaFahrenheit + 32;
                }else if(temperatura.equals("Kelvin")){
                    resultado = valorTemperatura + taxaKevin;
                }else{
                    resultado = valorTemperatura;
                }
            }else if(temperatura.equals("Fahrenheit")){
                if(temperatura2.equals("Kelvin")) {
                    resultado = (valorTemperatura - 32) * taxaFahrenheit + taxaKevin;
                }else if(temperatura.equals("Celsius")){
                    resultado = (valorTemperatura - 32) / taxaFahrenheit;
                }else{
                    resultado = valorTemperatura;
                }
            }else if(temperatura.equals("Kelvin")){
                if(temperatura2.equals("Fahrenheit")) {
                    resultado = (valorTemperatura - taxaKevin) * taxaFahrenheit + 32;
                }else if(temperatura.equals("Celsius")){
                    resultado = valorTemperatura - taxaKevin;
                }else{
                    resultado = valorTemperatura;
                }
            }
            txtResultado.setText(String.format("Valor convertido: %.2f Graus %s", resultado, temperatura2));
        });
    }
}