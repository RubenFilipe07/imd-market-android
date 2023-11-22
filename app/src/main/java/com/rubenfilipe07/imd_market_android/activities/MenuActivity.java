package com.rubenfilipe07.imd_market_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnCadastrar = findViewById(R.id.btnSalvar);
        btnCadastrar.setOnClickListener(v -> {
           Intent intent = new Intent(MenuActivity.this, CadastrarActivity.class);
           startActivity(intent);
        });
        Button btnAlterar = findViewById(R.id.button5);
        btnAlterar.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AlterarActivity.class);
            startActivity(intent);
        });
        Button btnListar = findViewById(R.id.button2);
        btnListar.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ListarActivity.class);
            startActivity(intent);
        });
        Button btnDeletar = findViewById(R.id.button4);
        btnDeletar.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DeletarActivity.class);
            startActivity(intent);
        });
    }

}