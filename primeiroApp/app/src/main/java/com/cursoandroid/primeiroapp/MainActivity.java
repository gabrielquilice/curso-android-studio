package com.cursoandroid.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarTexto (View view){
        TextView texto = findViewById(R.id.tvCliqueMain); //acessar id do text view
        String see = (String) texto.getText();
        if (see.equalsIgnoreCase("Clicou!") == true)
            texto.setText("Clique abaixo:");
        else
            texto.setText("Clicou!");
    }
}