package com.cursoandroid.aprendaingles.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.cursoandroid.aprendaingles.R

class NumerosFragment : Fragment() {
    private lateinit var btnUm: ImageView
    private lateinit var btnDois: ImageView
    private lateinit var btnTres: ImageView
    private lateinit var btnQuatro: ImageView
    private lateinit var btnCinco: ImageView
    private lateinit var btnSeis: ImageView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View =  inflater.inflate(R.layout.fragment_numeros, container, false)

        btnUm = view.findViewById(R.id.img1)
        btnDois = view.findViewById(R.id.img2)
        btnTres = view.findViewById(R.id.img3)
        btnQuatro = view.findViewById(R.id.img4)
        btnCinco = view.findViewById(R.id.img5)
        btnSeis = view.findViewById(R.id.img6)

        btnUm.setOnClickListener { tocarSom(R.raw.one) }
        btnDois.setOnClickListener { tocarSom(R.raw.two) }
        btnTres.setOnClickListener { tocarSom(R.raw.three) }
        btnQuatro.setOnClickListener { tocarSom(R.raw.four) }
        btnCinco.setOnClickListener { tocarSom(R.raw.five) }
        btnSeis.setOnClickListener { tocarSom(R.raw.six) }

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