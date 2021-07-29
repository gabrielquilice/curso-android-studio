package com.cursoandroid.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cursoandroid.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    public SobreFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .isRTL(false)
                .setImage(R.drawable.logo)
                .setDescription("A empresa com mais de 15 anos de experiência em te ajudar!")
                .addGroup("Entre em contato")
                .addEmail("atendimento@atm.com.br", "Nos envie um email")
                .addWebsite("https://atm.com.br", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("the.medy", "Facebook")
                .addTwitter("medyo80", "Twitter")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA", "YouTube")
                .addInstagram("medyo80", "Instagram")
                .addGroup("")
                .addItem(versao)
                .create();

    }
}