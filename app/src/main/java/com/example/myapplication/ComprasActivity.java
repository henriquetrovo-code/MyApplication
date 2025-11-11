package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ComprasActivity extends AppCompatActivity {

    HashMap<String, Integer> produtosMap;
    ArrayList<String> produtosExibicao;
    ArrayAdapter<String> spinnerAdapter;
    ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        produtosMap = new HashMap<>();
        produtosExibicao = new ArrayList<>();

        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produtosExibicao);

        EditText txtProduto = findViewById(R.id.txtProduto);
        EditText txtQuantidade = findViewById(R.id.txtQuantidade);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnRemover = findViewById(R.id.btnRemover);
        Spinner spProdutos = findViewById(R.id.spProdutos);
        ListView lista = findViewById(R.id.lista);

        spProdutos.setAdapter(spinnerAdapter);
        lista.setAdapter(listViewAdapter);

        btnAdicionar.setOnClickListener(v -> {
            String produto = txtProduto.getText().toString().trim();
            String qtdStr = txtQuantidade.getText().toString().trim();

            if (produto.isEmpty()) {
                txtProduto.setError("Digite um produto");
                return;
            }
            if (qtdStr.isEmpty()) {
                txtQuantidade.setError("Digite a quantidade");
                return;
            }

            int quantidade = Integer.parseInt(qtdStr);
            if (quantidade <= 0) {
                txtQuantidade.setError("Quantidade inválida");
                return;
            }

            int atual = produtosMap.getOrDefault(produto, 0);
            produtosMap.put(produto, atual + quantidade);
            atualizarExibicao();
            txtProduto.setText("");
            txtQuantidade.setText("");
        });

        btnRemover.setOnClickListener(v -> {
            String selecionado = (String) spProdutos.getSelectedItem();
            String qtdStr = txtQuantidade.getText().toString().trim();

            if (selecionado == null || !produtosMap.containsKey(selecionado)) return;
            if (qtdStr.isEmpty()) {
                txtQuantidade.setError("Digite a quantidade");
                return;
            }

            int quantidade = Integer.parseInt(qtdStr);
            if (quantidade <= 0) {
                txtQuantidade.setError("Quantidade inválida");
                return;
            }

            int atual = produtosMap.get(selecionado);
            if (atual > quantidade) {
                produtosMap.put(selecionado, atual - quantidade);
            } else {
                produtosMap.remove(selecionado);
            }
            atualizarExibicao();
            txtQuantidade.setText("");
        });
    }

    private void atualizarExibicao() {
        produtosExibicao.clear();
        ArrayList<String> nomes = new ArrayList<>();

        for (String produto : produtosMap.keySet()) {
            int qtd = produtosMap.get(produto);
            produtosExibicao.add(produto + " (x" + qtd + ")");
            nomes.add(produto);
        }

        spinnerAdapter.clear();
        spinnerAdapter.addAll(nomes);
        spinnerAdapter.notifyDataSetChanged();
        listViewAdapter.notifyDataSetChanged();
    }
}
