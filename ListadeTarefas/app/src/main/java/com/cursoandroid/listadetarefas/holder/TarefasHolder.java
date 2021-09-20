package com.cursoandroid.listadetarefas.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.listadetarefas.R;

public class TarefasHolder extends RecyclerView.ViewHolder {
    public TextView tituloTarefa;
    public ImageButton btnApagar;
    public ImageButton btnEditar;

    public TarefasHolder(@NonNull View itemView) {
        super(itemView);
        tituloTarefa = itemView.findViewById(R.id.textView);
        btnApagar = itemView.findViewById(R.id.imageButton);
        btnEditar = itemView.findViewById(R.id.imageButton2);
    }
}
