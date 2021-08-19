package com.cursoandroid.sharedpreferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnSalvar: Button
    private lateinit var edtNome: TextInputEditText
    private lateinit var txtResultado: TextView
    private lateinit var preferences: SharedPreferences

    val ARQUIVO_PREFERENCIA = "aRQUIVOpREFERENCIA"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar = findViewById(R.id.button)
        edtNome = findViewById(R.id.edtNome)
        txtResultado = findViewById(R.id.txtResultado)

        preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0)

        if (preferences.contains("nome")){
            txtResultado.text = "Olá " + preferences.getString("nome", "!!!")
        } else {
            txtResultado.text = "Olá !!!"
        }

        btnSalvar.setOnClickListener {
            var editor: SharedPreferences.Editor = preferences.edit()

            if (edtNome.text.toString() == "") {
                Toast.makeText(applicationContext, "Preencha o nome!", Toast.LENGTH_SHORT).show()
            } else {

                val nome = edtNome.text.toString()
                editor.putString("nome", nome)
                editor.commit()

                txtResultado.text = "Olá $nome"
            }
        }

    }
}