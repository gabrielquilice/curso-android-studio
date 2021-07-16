package com.cursoandroid.passando_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.button);

        btnEnviar.setOnClickListener(v -> {
            Usuario usuario = new Usuario("Usuario1", "teste@teste.com");

            Intent itDados = new Intent(getApplicationContext(), SegundaActivity.class);
            itDados.putExtra("nome", "Teste");
            itDados.putExtra("idade", 20);
            itDados.putExtra("objeto", (Serializable) usuario);
            startActivity(itDados);
        });
    }

}