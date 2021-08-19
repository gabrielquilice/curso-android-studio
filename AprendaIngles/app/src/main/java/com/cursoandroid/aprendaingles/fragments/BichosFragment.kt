package com.cursoandroid.aprendaingles.fragments

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.cursoandroid.aprendaingles.R

class BichosFragment : Fragment() {
    private lateinit var btnCao: ImageView
    private lateinit var btnGato: ImageView
    private lateinit var btnLeao: ImageView
    private lateinit var btnMacaco: ImageView
    private lateinit var btnOvelha: ImageView
    private lateinit var btnVaca: ImageView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_bichos, container, false)

        btnCao = view.findViewById(R.id.imgCao)
        btnGato = view.findViewById(R.id.imgGato)
        btnLeao = view.findViewById(R.id.imgLeao)
        btnMacaco = view.findViewById(R.id.imgMacaco)
        btnOvelha = view.findViewById(R.id.imgOvelha)
        btnVaca = view.findViewById(R.id.imgVaca)

        btnCao.setOnClickListener { tocarSom(R.raw.dog) }
        btnGato.setOnClickListener { tocarSom(R.raw.cat) }
        btnLeao.setOnClickListener { tocarSom(R.raw.lion) }
        btnMacaco.setOnClickListener { tocarSom(R.raw.monkey) }
        btnOvelha.setOnClickListener { tocarSom(R.raw.sheep) }
        btnVaca.setOnClickListener { tocarSom(R.raw.cow) }

        return view
    }

    fun tocarSom(res: Int){
        try {
            mediaPlayer = MediaPlayer.create(context, res)
            mediaPlayer.start()

            mediaPlayer.setOnCompletionListener { mediaPlayer.release() }
        } catch (e: Exception){
            Toast.makeText(context, "Algo deu errado, tente novamente...", Toast.LENGTH_SHORT).show()
        }
    }
}