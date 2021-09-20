package com.cursoandroid.listadetarefas.activities;

import android.content.Intent;
import android.os.Bundle;

import com.cursoandroid.listadetarefas.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.listadetarefas.adapter.TarefasAdapter;
import com.cursoandroid.listadetarefas.dao.TarefaDao;
import com.cursoandroid.listadetarefas.databinding.ActivityMainBinding;
import com.cursoandroid.listadetarefas.model.Tarefa;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TarefasAdapter tarefasAdapter;
    public static List<Tarefa> listaTarefas = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        recyclerView = findViewById(R.id.rvTarefas);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itNovaTarefa = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                startActivity(itNovaTarefa);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadListaTarefas();
    }

    private void loadListaTarefas(){
        TarefaDao tarefaDao = new TarefaDao(this);
        listaTarefas = tarefaDao.getListaTarefas();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        tarefasAdapter = new TarefasAdapter(listaTarefas, this);
        recyclerView.setAdapter(tarefasAdapter);
    }

}