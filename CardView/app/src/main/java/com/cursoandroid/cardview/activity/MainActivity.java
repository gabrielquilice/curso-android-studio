package com.cursoandroid.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cursoandroid.cardview.R;
import com.cursoandroid.cardview.adapter.PostagemAdapter;
import com.cursoandroid.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Postagem> postagemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        prepararPostagens();

        PostagemAdapter postagemAdapter = new PostagemAdapter(postagemList);
        recyclerView.setAdapter(postagemAdapter);
    }

    public void prepararPostagens(){
        Postagem p = new Postagem("Titulo 1", "Legenda 1", R.drawable.imagem1);
        this.postagemList.add(p);

        p = new Postagem("Titulo 2", "Legenda 2", R.drawable.imagem2);
        this.postagemList.add(p);

        p = new Postagem("Titulo 3", "Legenda 3", R.drawable.imagem3);
        this.postagemList.add(p);

        p = new Postagem("Titulo 4", "Legenda 4", R.drawable.imagem4);
        this.postagemList.add(p);
    }
}