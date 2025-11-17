package com.example.myapplication.EmpresaClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class HorasExtrasActivity extends AppCompatActivity {

    public Button btnReceberHoras;
    public static EditText txtHoras;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receber_horas);

        btnReceberHoras = findViewById(R.id.btnReceberHoras);
        txtHoras = findViewById(R.id.txtHoras);

        btnReceberHoras.setOnClickListener(v -> {
            Desenvolvedor.receber_horas();
            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent); // devolve o resultado
            finish(); // fecha e volta para FuncionariosActivity
        });

    }
}