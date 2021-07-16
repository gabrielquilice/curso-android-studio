package com.cursoandroid.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada(0);
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada(1);
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada(2);
    }


    public void opcaoSelecionada(int opcao){

        ImageView imageResultado = findViewById(R.id.imgEscolhaApp);
        TextView resultado = findViewById(R.id.textView2);

        int numero = new Random().nextInt(3);
        int[] valores = {0, 1, 2};
        int escolhaApp = valores[numero];

        switch (escolhaApp){
            case 0:
                imageResultado.setImageResource(R.drawable.pedra);
                if (opcao == 1) resultado.setText("Você ganhou!!!");
                if (opcao == 2) resultado.setText("Você perdeu :(");
                break;
            case 1:
                imageResultado.setImageResource(R.drawable.papel);
                if (opcao == 0) resultado.setText("Você perdeu :(");
                if (opcao == 2) resultado.setText("Você ganhou!!!");
                break;
            case 2:
                imageResultado.setImageResource(R.drawable.tesoura);
                if (opcao == 0) resultado.setText("Você ganhou!!!");
                if (opcao == 1) resultado.setText("Você perdeu :(");
                break;
        }

        if (escolhaApp == opcao) resultado.setText("Empate!");
    }
}