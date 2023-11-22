package com.rubenfilipe07.imd_market_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
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
        List<Produto> listaProdutos = getIntent().getParcelableArrayListExtra("produtos");
        ArrayAdapter<Produto> adapter = new ListViewAdapter(this, listaProdutos);
        lw.setAdapter(adapter);
        findViewById(R.id.btnVoltar).setOnClickListener(v -> {
                Intent intent = new Intent(ListarActivity.this, MenuActivity.class);
                startActivity(intent);
        });
    }

}