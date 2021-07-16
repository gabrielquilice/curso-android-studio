package com.cursoandroid.get_set;

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

    public void testando(View view){
        Teste teste = new Teste();
        TextView label = findViewById(R.id.textView);

        label.setText("Teste:" + teste.getNumero());
    }
}