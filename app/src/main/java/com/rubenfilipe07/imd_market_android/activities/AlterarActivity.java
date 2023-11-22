package com.rubenfilipe07.imd_market_android.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;

public class AlterarActivity extends AppCompatActivity {

    private EditText codigoProduto;
    private EditText nomeProduto;
    private EditText descricaoProduto;
    private EditText estoqueProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);
        codigoProduto = findViewById(R.id.codigo);
        nomeProduto = findViewById(R.id.nome);
        descricaoProduto = findViewById(R.id.descricao);
        estoqueProduto = findViewById(R.id.estoque);
        findViewById(R.id.btnAbrirCadastroProduto).setOnClickListener(v -> {
                alterar();
        });
      findViewById(R.id.btnDeletarProduto).setOnClickListener(v -> limpar());
    }

    public void alterar() {
        BancoAdmin bancoAdmin = new BancoAdmin(this);
        SQLiteDatabase banco = bancoAdmin.getWritableDatabase();
        String codigoProdutoStr = codigoProduto.getText().toString();
        String nomeProdutoStr = nomeProduto.getText().toString();
        String descricaoProdutoStr = descricaoProduto.getText().toString();
        String estoqueProdutoStr = estoqueProduto.getText().toString();
        if (!codigoProdutoStr.isEmpty()) {
            ContentValues alteracao = new ContentValues();
            if (!nomeProdutoStr.isEmpty()) {
                alteracao.put("nome_produto", nomeProdutoStr);
            }
            if (!descricaoProdutoStr.isEmpty()) {
                alteracao.put("descricao_produto", descricaoProdutoStr);
            }
            if (!estoqueProdutoStr.isEmpty()) {
                alteracao.put("estoque", Integer.valueOf(estoqueProdutoStr));
            }
            try {
                if (banco.update("produtos", alteracao, "codigo_produto=" + codigoProdutoStr, null) > 0) {
                    Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Erro ao alterar registro no banco de dados.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Erro inesperado ao tentar alterar produto.", Toast.LENGTH_SHORT).show();
            } finally {
                banco.close();
                Intent intent = new Intent(AlterarActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Código de produto é obrigatório", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpar() {
        codigoProduto.setText("");
        nomeProduto.setText("");
        descricaoProduto.setText("");
        estoqueProduto.setText("");
    }

}