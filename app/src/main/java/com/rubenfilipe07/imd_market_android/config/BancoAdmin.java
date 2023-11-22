package com.rubenfilipe07.imd_market_android.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoAdmin extends SQLiteOpenHelper {

    private static final String BD_NAME = "bd_produtos";

    public BancoAdmin(@Nullable Context context) {
        super(context, BD_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        banco.execSQL("CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo_produto VARCHAR, nome_produto VARCHAR, descricao_produto VARCHAR, estoque INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

}
