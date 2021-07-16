package com.cursoandroid.passando_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtNome, txtIdade;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);

        txtNome.setText( getIntent().getStringExtra("nome") );
        txtIdade.setText( String.valueOf(getIntent().getIntExtra("idade", 0)) );

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        usuario = (Usuario) getIntent().getSerializableExtra("objeto");

        txtNome.setText( usuario.getEmail() );
    }
}