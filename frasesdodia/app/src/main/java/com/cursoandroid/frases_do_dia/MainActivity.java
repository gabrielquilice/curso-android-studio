package com.cursoandroid.frases_do_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){
        String[] frases = {
                "Aproveite o tempo que tem: você não sabe quando ele vai acabar...",
                "Frase 1",
                "Frase 2",
                "Frase 3"
        };

        TextView texto = findViewById(R.id.tvResultado);
        int num = new Random().nextInt(frases.length);
        texto.setText(frases[num]);
    }
}