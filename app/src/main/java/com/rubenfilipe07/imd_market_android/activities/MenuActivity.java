package com.rubenfilipe07.imd_market_android.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;
import com.rubenfilipe07.imd_market_android.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        carregarDados();
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
            intent.putParcelableArrayListExtra("produtos", new ArrayList<>(produtos));
            startActivity(intent);
        });
        Button btnDeletar = findViewById(R.id.btnLimpar);
        btnDeletar.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DeletarActivity.class);
            startActivity(intent);
        });
    }

    private void carregarDados() {
        BancoAdmin bancoAdmin = new BancoAdmin(this);
        SQLiteDatabase banco = bancoAdmin.getReadableDatabase();
        Cursor query = banco.rawQuery("select codigo_produto, nome_produto, descricao_produto, estoque from produtos", null);
        while (query.moveToNext()) {
            produtos.add(new Produto(query.getString(0), query.getString(1), query.getString(2), Integer.valueOf(query.getString(3))));
        }
    }

}