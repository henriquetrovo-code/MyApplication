// CORRIJA ESTA LINHA
package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepActivity extends AppCompatActivity {

    // Adicionar a anotação @Override é uma boa prática de programação.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Certifique-se de que o nome do seu arquivo XML de layout é "cep.xml"
        setContentView(R.layout.cep);

        EditText txtCEP = findViewById(R.id.txtCEP);
        Button btnConsultaCEP = findViewById(R.id.btnConsultaCEP);
        TextView txtResultadoCEP = findViewById(R.id.txtResultadoCEP);

        btnConsultaCEP.setOnClickListener(v -> {
            String cep = txtCEP.getText().toString().trim(); // .trim() remove espaços em branco

            if (cep.length() == 8) { // Valida se o CEP tem 8 dígitos
                buscarEndereco(cep, txtResultadoCEP);
            } else {
                txtResultadoCEP.setText("Digite um CEP válido com 8 dígitos.");
            }
        });
    }

    private void buscarEndereco(String cep, TextView txtResultadoCEP) {
        // Exibe uma mensagem de "carregando" para o usuário
        txtResultadoCEP.setText("Buscando...");

        new Thread(() -> {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder resultado = new StringBuilder();
                String linha;

                while ((linha = reader.readLine()) != null) {
                    resultado.append(linha);
                }

                reader.close();
                connection.disconnect(); // É uma boa prática fechar a conexão

                JSONObject jsonObject = new JSONObject(resultado.toString());

                // A API ViaCEP retorna {"erro": true} para CEPs inválidos
                if (jsonObject.has("erro")) {
                    runOnUiThread(() -> txtResultadoCEP.setText("CEP não encontrado."));
                } else {
                    String logradouro = jsonObject.optString("logradouro", "");
                    String bairro = jsonObject.optString("bairro", "");
                    String localidade = jsonObject.optString("localidade", "");
                    String uf = jsonObject.optString("uf", "");

                    // Garante que o texto não comece com vírgulas se os campos estiverem vazios
                    String endereco = "Logradouro: " + logradouro + "\n" +
                            "Bairro: " + bairro + "\n" +
                            "Cidade: " + localidade + " - " + uf;

                    runOnUiThread(() -> txtResultadoCEP.setText(endereco));
                }

            } catch (Exception e) {
                // Informa ao usuário sobre falhas de conexão ou outros erros
                runOnUiThread(() -> txtResultadoCEP.setText("Falha ao buscar o CEP. Verifique sua conexão."));
                e.printStackTrace();
            }
        }).start();
    }
}
