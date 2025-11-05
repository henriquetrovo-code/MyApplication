package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PetActivity extends AppCompatActivity {

    private ImageView imgDog;
    private Button btnCarregarImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet);

        imgDog = findViewById(R.id.imgpet);
        btnCarregarImagem = findViewById(R.id.btnCarregarImagem);

        btnCarregarImagem.setOnClickListener(v -> carregarImagem());
    }

    private void carregarImagem() {
        new Thread(() -> {
            try {
                URL apiUrl = new URL("https://dog.ceo/api/breeds/image/random");
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                StringBuilder resultado = new StringBuilder();
                int ch;
                while ((ch = inputStream.read()) != -1) {
                    resultado.append((char) ch);
                }
                inputStream.close();

                JSONObject jsonObject = new JSONObject(resultado.toString());
                String imageUrl = jsonObject.getString("message");

                URL urlImagem = new URL(imageUrl);
                HttpURLConnection imgConnection = (HttpURLConnection) urlImagem.openConnection();
                InputStream imgStream = imgConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(imgStream);

                // 3. Atualizar a UI
                runOnUiThread(() -> imgDog.setImageBitmap(bitmap));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}