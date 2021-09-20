package com.cursoandroid.listadetarefas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.listadetarefas.R;
import com.cursoandroid.listadetarefas.activities.AdicionarTarefaActivity;
import com.cursoandroid.listadetarefas.dao.TarefaDao;
import com.cursoandroid.listadetarefas.holder.TarefasHolder;
import com.cursoandroid.listadetarefas.model.Tarefa;

import java.util.List;

public class TarefasAdapter extends RecyclerView.Adapter<TarefasHolder> {
    private List<Tarefa> listaTarefas;
    private Context context;

    public TarefasAdapter(List<Tarefa> listaTarefas, Context context) {
        this.listaTarefas = listaTarefas;
        this.context = context;
    }

    @NonNull
    @Override
    public TarefasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarefas_lista, parent, false);
        return new TarefasHolder(item);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull TarefasHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);

        try {
            if(tarefa.getFgFinalizada().equals("S")) {
                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.fg_finalizada));
            }

            holder.tituloTarefa.setOnClickListener(view -> {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle(tarefa.getFgFinalizada().equals("N") ? "CONCLUIR" : "DESMARCAR");
                dialog.setMessage(tarefa.getFgFinalizada().equals("N") ? "Deseja marcar a nota como concluída?" : "Deseja desmarcar a nota como concluída?");
                dialog.setPositiveButton("SIM", (dialog1, which) -> {
                    try {
                        TarefaDao tarefaDao = new TarefaDao(context);
                        tarefa.setFgFinalizada( tarefa.getFgFinalizada().equals("N") ? "S" : "N" );
                        if (tarefaDao.alterarStatus(tarefa)) {
                            notifyItemChanged(position);
                        }
                    } catch (Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("NÃO", (dialog2, which) -> {
                    dialog2.dismiss();
                });
                dialog.show();
            });

            holder.btnEditar.setOnClickListener(view -> {
                Intent intent = new Intent(context, AdicionarTarefaActivity.class);
                intent.putExtra("idTarefa", tarefa.getId());
                context.startActivity(intent);
            });

            holder.btnApagar.setOnClickListener(view -> {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("EXCLUIR");
                dialog.setMessage("Deseja excluir essa nota?");
                dialog.setPositiveButton("SIM", (dialog1, which) -> {
                    try {
                        TarefaDao tarefaDao = new TarefaDao(context);
                        if (tarefaDao.deletar(tarefa)) {
                            listaTarefas.remove(tarefa);
                            notifyItemRemoved(position);
                            Toast.makeText(context, "Tarefa excluída com sucesso!", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("NÃO", (dialog2, which) -> {
                    dialog2.dismiss();
                });
                dialog.show();
            });

            holder.tituloTarefa.setText(tarefa.getTitulo());
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }
}
