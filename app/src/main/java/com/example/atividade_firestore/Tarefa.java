package com.example.atividade_firestore;

import java.util.Date;

public class Tarefa {
    private String titulo, categoria, prioridade;
    private Date dataCricao;

    public Tarefa(String titulo, String categoria, String prioridade, Date dataCriacao) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.dataCricao = dataCriacao;
    }

    public Tarefa() {
    }

    public Date getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(Date dataCricao) {
        this.dataCricao = dataCricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
