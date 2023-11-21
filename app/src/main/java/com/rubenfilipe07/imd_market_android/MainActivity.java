package com.rubenfilipe07.imd_market_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase bancoDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaSharedPreferences();
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

    public void login(View view) {
        EditText inputLogin = findViewById(R.id.inputLogin);
        EditText inputSenha = findViewById(R.id.inputSenha);
        String login = inputLogin.getText().toString();
        String senha = inputSenha.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String loginShared = sharedPreferences.getString("login", "");
        String senhaShared = sharedPreferences.getString("senha", "");
        if (login.equals(loginShared) && senha.equals(senhaShared)) {
            setContentView(R.layout.activity_menu);
        }
    }


    public void inicializaSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("login", "admin");
        editor.putString("senha", "admin");
        editor.commit();
    }
}

