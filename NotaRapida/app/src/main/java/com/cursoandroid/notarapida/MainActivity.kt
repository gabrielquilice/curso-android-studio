package com.cursoandroid.notarapida

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ScrollView
import androidx.core.text.set
import com.cursoandroid.notarapida.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: MyPreferences
    private lateinit var edtAnotacao: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = MyPreferences(applicationContext)
        edtAnotacao = findViewById(R.id.edtAnotacao)

        var previousText = preferences.getValue()
        if (previousText != ""){
            edtAnotacao.setText(previousText)
        }

        binding.fab.setOnClickListener { view ->
            if (edtAnotacao.text.toString() != previousText) {
                try {
                    preferences.setValue(edtAnotacao.text.toString())
                    Snackbar.make(view, "Anotação salva!", Snackbar.LENGTH_LONG).show()
                } catch (e: Exception){
                    Snackbar.make(view, "Erro, tente novamente", Snackbar.LENGTH_LONG).show()
                }

            } else {
                Snackbar.make(view, "Altere o texto para salvar!", Snackbar.LENGTH_LONG).show()
            }
        }

    }

}