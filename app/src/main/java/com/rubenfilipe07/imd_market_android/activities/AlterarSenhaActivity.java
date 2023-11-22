package com.rubenfilipe07.imd_market_android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rubenfilipe07.imd_market_android.R;

public class AlterarSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        Button btnAlterarSenha = findViewById(R.id.btnAlterarSenha);
        btnAlterarSenha.setOnClickListener(v -> {
         alterarSenha();
        });


    }

    public void alterarSenha() {

        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);


        EditText inputLogin = findViewById(R.id.inputLogin);
        EditText inputSenha = findViewById(R.id.inputSenha);
        if (inputLogin.getText().toString().isEmpty() || inputSenha.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            String loginInput = inputLogin.getText().toString();
            String senhaInput = inputSenha.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("login", loginInput);
            editor.putString("senha", senhaInput);
            editor.commit();
            Toast.makeText(this, "Credenciais alteradas com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }


}