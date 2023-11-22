package com.rubenfilipe07.imd_market_android.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;
import com.rubenfilipe07.imd_market_android.domain.Produto;
import com.rubenfilipe07.imd_market_android.util.ListViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        ListView lw = findViewById(R.id.lista);
        ArrayAdapter<Produto> adapter = new ListViewAdapter(this, buscarTodos());
        lw.setAdapter(adapter);
        findViewById(R.id.btnVoltar).setOnClickListener(v -> {
                Intent intent = new Intent(ListarActivity.this, MenuActivity.class);
                startActivity(intent);
        });
    }

    private List<Produto> buscarTodos() {
        List<Produto> produtos = new ArrayList<>();
        BancoAdmin bancoAdmin = new BancoAdmin(this);
        SQLiteDatabase banco = bancoAdmin.getReadableDatabase();
        Cursor query = banco.rawQuery("select codigo_produto, nome_produto, descricao_produto, estoque from produtos order by nome_produto", null);
        while (query.moveToNext()) {
            produtos.add(new Produto(query.getString(0), query.getString(1), query.getString(2), Integer.valueOf(query.getString(3))));
        }
        return produtos;
    }

}