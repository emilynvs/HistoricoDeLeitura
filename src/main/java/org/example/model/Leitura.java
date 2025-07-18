package org.example.model;

import java.time.LocalDate;

public class Leitura {
    private int id;
    private int idLivro;
    private int paginasLidas;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int nota;                  // 1 a 5
    private String comentario;
    private boolean releitura;

    public Leitura() {
    }

    public Leitura(int idLivro, int paginasLidas, LocalDate dataInicio, LocalDate dataFim, int nota, String comentario, boolean releitura) {
        this.idLivro = idLivro;
        this.paginasLidas = paginasLidas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.nota = nota;
        this.comentario = comentario;
        this.releitura = releitura;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isReleitura() {
        return releitura;
    }

    public void setReleitura(boolean releitura) {
        this.releitura = releitura;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getPaginasLidas() {
        return paginasLidas;
    }

    public void setPaginasLidas(int paginasLidas) {
        this.paginasLidas = paginasLidas;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Leitura{" +
                "dataInicio=" + dataInicio +
                ", idLivro=" + idLivro +
                ", paginasLidas=" + paginasLidas +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
