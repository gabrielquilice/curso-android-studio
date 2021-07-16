package com.cursoandroid.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "São Paulo", "Porto Seguro", "Rio de Janeiro",
            "Buenos Aires", "Barcelona", "Madri", "Lisboa",
            "Paris", "Roma", "Milão", "Aleppo", "Beirute",
            "Jerusalém", "Tóquio"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //Criação de adaptador para lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //layout a ser utilizado pelo adaptador
                android.R.id.text1, //View que será utilizada
                itens //lista que será adaptada
        );

        listLocais.setAdapter(adapter);

        listLocais.setOnItemClickListener((parent, view, position, id) -> {
            String valor = listLocais.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), valor, Toast.LENGTH_SHORT).show();
        });
    }
}