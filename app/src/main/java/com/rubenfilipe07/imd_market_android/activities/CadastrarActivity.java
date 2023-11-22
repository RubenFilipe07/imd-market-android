package com.rubenfilipe07.imd_market_android.activities;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        Button btnCadastrar = findViewById(R.id.btnSalvar);
        btnCadastrar.setOnClickListener(v -> {
            BancoAdmin bancoAdmin = new BancoAdmin(this);
            SQLiteDatabase banco = bancoAdmin.getWritableDatabase();
            String codigoProduto = ((EditText) findViewById(R.id.editTextText2)).getText().toString();
            String nomeProduto = ((EditText) findViewById(R.id.editTextText6)).getText().toString();
            String descricaoProduto = ((EditText) findViewById(R.id.editTextText8)).getText().toString();
            String estoqueProduto = ((EditText)findViewById(R.id.editTextNumber)).getText().toString();
            if (!codigoProduto.isEmpty() && !nomeProduto.isEmpty() && !descricaoProduto.isEmpty() && !estoqueProduto.isEmpty()) {
                ContentValues cadastro = new ContentValues();
                cadastro.put("nome_produto", nomeProduto);
                cadastro.put("codigo_produto", codigoProduto);
                cadastro.put("descricao_produto", descricaoProduto);
                cadastro.put("estoque", Integer.valueOf(estoqueProduto));
                banco.insert("produtos", null, cadastro);
                banco.close();
                Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Um ou mais campos vazios", Toast.LENGTH_SHORT).show();
            }
        });
    }

}