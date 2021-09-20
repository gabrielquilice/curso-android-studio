package com.cursoandroid.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private final Context context;

    public static int VERSION = 1;
    public static String NAME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " titulo TEXT NOT NULL, " +
                " fgFinalizada CHAR(1) NOT NULL); ";

        try {
            db.execSQL(sql);
            Log.i("DB_INFO", "Tabela criada com sucesso!");
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            Log.i("DB_INFO", "Erro: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
