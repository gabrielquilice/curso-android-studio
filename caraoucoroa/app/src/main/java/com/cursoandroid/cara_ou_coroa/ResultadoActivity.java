package com.cursoandroid.cara_ou_coroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imgResultado, imgVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imgResultado = findViewById(R.id.imgResultado);
        imgVoltar = findViewById(R.id.imgVoltar);

        imgVoltar.setOnClickListener(v -> finish());

        sortear( getIntent().getIntExtra("numero", 0));
    }

    private void sortear(int num){
        if(num % 2 == 0){
            imgResultado.setImageResource(R.drawable.moeda_cara);
        } else {
            imgResultado.setImageResource(R.drawable.moeda_coroa);
        }
    }
}