package com.rubenfilipe07.imd_market_android.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnCadastrar = findViewById(R.id.button3);
        btnCadastrar.setOnClickListener(v -> {

        });

    }

}