package com.rubenfilipe07.imd_market_android.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;

public class CadastrarActivity extends AppCompatActivity {

    private EditText codigoProduto;
    private EditText nomeProduto;
    private EditText descricaoProduto;

    private EditText estoqueProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        codigoProduto = findViewById(R.id.codigo);
        nomeProduto = findViewById(R.id.nome);
        descricaoProduto = findViewById(R.id.descricao);
        estoqueProduto = findViewById(R.id.estoque);
        Button btrnSalvar = findViewById(R.id.btnAbrirCadastroProduto);
        btrnSalvar.setOnClickListener(v -> cadastrar());
        Button btnLimpar = findViewById(R.id.btnDeletarProduto);
        btnLimpar.setOnClickListener(v -> limpar());
    }

    private void cadastrar() {
        BancoAdmin bancoAdmin = new BancoAdmin(this);
        SQLiteDatabase banco = bancoAdmin.getWritableDatabase();
        String codigoProdutoStr = codigoProduto.getText().toString();
        String nomeProdutoStr = nomeProduto.getText().toString();
        String descricaoProdutoStr = descricaoProduto.getText().toString();
        String estoqueProdutoStr = estoqueProduto.getText().toString();
        if (!codigoProdutoStr.isEmpty() && !nomeProdutoStr.isEmpty() && !descricaoProdutoStr.isEmpty() && !estoqueProdutoStr.isEmpty()) {
            ContentValues cadastro = new ContentValues();
            cadastro.put("nome_produto", nomeProdutoStr);
            cadastro.put("codigo_produto", codigoProdutoStr);
            cadastro.put("descricao_produto", descricaoProdutoStr);
            cadastro.put("estoque", Integer.valueOf(estoqueProdutoStr));
            try {
                if (banco.insert("produtos", null, cadastro) != -1) {
                    Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Erro ao inserir registro no banco de dados.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Erro inesperado ao tentar cadastrar produto.", Toast.LENGTH_SHORT).show();
            } finally {
                banco.close();
                Intent intent = new Intent(CadastrarActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Um ou mais campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpar() {
        codigoProduto.setText("");
        nomeProduto.setText("");
        descricaoProduto.setText("");
        estoqueProduto.setText("");
    }

}