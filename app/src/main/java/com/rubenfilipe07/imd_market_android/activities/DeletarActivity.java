package com.rubenfilipe07.imd_market_android.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.config.BancoAdmin;

public class DeletarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        Button btnDeletar = findViewById(R.id.btnDeletar);
        EditText editTextCodigo = findViewById(R.id.editTextCodigo);
        Button btnLimpar = findViewById(R.id.btnDeletarProduto);

        btnLimpar.setOnClickListener(v -> limpar());

        btnDeletar.setOnClickListener(v -> {

            if (editTextCodigo.getText().toString().isEmpty()) {
                Toast.makeText(this, "Digite um código válido", Toast.LENGTH_SHORT).show();
            } else {
                int codigo = Integer.parseInt(editTextCodigo.getText().toString());
                if (codigo >= 0) {
                    deletarProduto(codigo);
                } else {
                    Toast.makeText(this, "Digite um código válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void deletarProduto(int codigo) {
        BancoAdmin bancoAdmin = new BancoAdmin(this);
        SQLiteDatabase banco = bancoAdmin.getWritableDatabase();

        if (banco.rawQuery("SELECT * FROM produtos WHERE codigo_produto = ?", new String[]{String.valueOf(codigo)}).getCount() == 0 ) {
            Toast.makeText(this, "Produto não encontrado, tente outro", Toast.LENGTH_SHORT).show();;
        }else{
            banco.execSQL("DELETE FROM produtos WHERE codigo_produto = ?", new Object[]{codigo});
            Toast.makeText(this, "Produto deletado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DeletarActivity.this, MenuActivity.class);
            startActivity(intent);
        }
        banco.close();
    }

    private void limpar() {
        EditText editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextCodigo.setText(null);
    }
}