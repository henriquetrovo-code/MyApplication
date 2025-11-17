package com.example.myapplication.EmpresaClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class BonusGerenteActivity extends AppCompatActivity {

    public Button btnReceberBonus;
    public static EditText txtBonus;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receber_bonus);

        btnReceberBonus = findViewById(R.id.btnReceberHoras);
        txtBonus = findViewById(R.id.txtHoras);

        btnReceberBonus.setOnClickListener(v -> {
            Gerente.receber_bonus();
            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent); // devolve o resultado
            finish(); // fecha e volta para FuncionariosActivity
        });

    }
}