package com.rubenfilipe07.imd_market_android.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.util.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        ListView lw = findViewById(R.id.lista);
        List<String> itemList = new ArrayList<>();
        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        ArrayAdapter<String> adapter = new ListViewAdapter(this, itemList);
        lw.setAdapter(adapter);
    }

}