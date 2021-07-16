package com.cursoandroid.cara_ou_coroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgJogar = findViewById(R.id.imgJogar);
        imgJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itResultado = new Intent(getApplicationContext(), ResultadoActivity.class);
                itResultado.putExtra("numero", gerarNumeroAleatorio());
                startActivity(itResultado);
            }
        });
    }

    private int gerarNumeroAleatorio(){
        int num = new Random().nextInt(25);
        return num;
    }
}