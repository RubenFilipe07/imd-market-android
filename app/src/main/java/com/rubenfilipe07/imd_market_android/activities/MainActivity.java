package com.rubenfilipe07.imd_market_android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rubenfilipe07.imd_market_android.R;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase bancoDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaSharedPreferences();

        TextView linkAlterarSenha = findViewById(R.id.linkAlterarSenha);
        linkAlterarSenha.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlterarSenhaActivity.class);
            startActivity(intent);
        });
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
           alteraTelaMenu();
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }

    public void inicializaSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString("login", "").equals("")) {
            editor.putString("login", "admin");
            editor.putString("senha", "admin");
            editor.commit();
        }
    }

    public void alteraTelaMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void abrirAlterarSenha(View view) {
        Intent intent = new Intent(this, AlterarSenhaActivity.class);
        startActivity(intent);
    }
}

