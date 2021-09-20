package com.cursoandroid.listadetarefas.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tarefa {
    private Long id;
    private String titulo;
    private String fgFinalizada;
}
