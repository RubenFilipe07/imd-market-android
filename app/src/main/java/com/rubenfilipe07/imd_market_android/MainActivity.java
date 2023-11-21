package com.rubenfilipe07.imd_market_android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criarBancoDados();
    }

    public void criarBancoDados() {
        try {
            bancoDados = openOrCreateDatabase("produtos", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo_produto VARCHAR, nome_produto VARCHAR, descricao_produto VARCHAR, estoque INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

