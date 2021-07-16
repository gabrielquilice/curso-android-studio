package com.cursoandroid.passando_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);

        txtNome.setText( getIntent().getStringExtra("nome") );
        txtIdade.setText( String.valueOf(getIntent().getIntExtra("idade", 0)) );
    }
}