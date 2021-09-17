package com.cursoandroid.sqlite;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Pessoa> resultado = new ArrayList<>();
    private EditText editText;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            editText = findViewById(R.id.editText);

            //Criar o banco
            SQLiteDatabase bd = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Deletar tabela
            bd.execSQL("DROP TABLE IF EXISTS pessoas");

            //Criar tabela
            bd.execSQL("CREATE TABLE pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(100), idade INT(3))");

            //Inserir dados
            bd.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('José', 21)");
            bd.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Maria', 20)");

            //Recuperar pessoas
            Cursor cursor = bd.rawQuery("SELECT id, nome, idade FROM pessoas", null);

            int indexId = cursor.getColumnIndex("id");
            int indexNome = cursor.getColumnIndex("nome");
            int indexIdade = cursor.getColumnIndex("idade");

            int totalPosicoes = 1;

            cursor.moveToFirst();

            while(totalPosicoes <= cursor.getCount()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(Integer.parseInt(cursor.getString(indexId)));
                pessoa.setNome(cursor.getString(indexNome));
                pessoa.setIdade(Integer.parseInt(cursor.getString(indexIdade)));
                resultado.add(pessoa);
                cursor.moveToNext();
                totalPosicoes++;
            }

            resultado.forEach(pessoa -> editText.append("\n" + pessoa.getId() + ") " + pessoa.getNome() + " - " + pessoa.getIdade() + " anos"));

        } catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}