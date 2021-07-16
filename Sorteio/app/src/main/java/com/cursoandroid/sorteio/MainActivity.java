package com.cursoandroid.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Produto produto = new Produto();
        produto.getId();
    }

    public void sortearNumero(View view){
        TextView texto = findViewById(R.id.tvNumeroMain);
        int numero = new Random().nextInt(11); //criação de números aleatórios de 0 a 11, com 11 não incluso
        texto.setText("O número sorteado foi: "+ numero);

        Button botao = findViewById(R.id.button);
        botao.setText("Jogar novamente");
    }
}