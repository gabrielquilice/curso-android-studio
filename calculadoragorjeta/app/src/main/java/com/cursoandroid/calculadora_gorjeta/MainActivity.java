package com.cursoandroid.calculadora_gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Precision;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText edt_Valor;
    private TextView txt_Porcentagem;
    private TextView txt_ValorGorjeta;
    private TextView txt_ValorTotal;
    private SeekBar sb_Gorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Valor = findViewById(R.id.edt_Valor);
        txt_Porcentagem = findViewById(R.id.txt_Porcentagem);
        txt_ValorGorjeta = findViewById(R.id.txt_ValorGorjeta);
        txt_ValorTotal = findViewById(R.id.txt_ValorTotal);
        sb_Gorjeta = findViewById(R.id.sb_Gorjeta);

        sb_Gorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                txt_Porcentagem.setText(Math.round(porcentagem)+"%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcular(){
        String valorRecuperado = edt_Valor.getText().toString();

        if (valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_SHORT).show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = valorDigitado + gorjeta;

            BigDecimal totalFormatado = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);

            txt_ValorGorjeta.setText("R$"+Math.round(gorjeta));
            txt_ValorTotal.setText("R$"+totalFormatado);
        }
    }
}