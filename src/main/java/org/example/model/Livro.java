package org.example.model;

import org.example.model.enums.Formato;
import org.example.model.enums.Status;

import java.util.EnumSet;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int paginas;
    private Status status;
    private Formato formato;


    public Livro() {
    }

    public Livro(String titulo, String autor, int paginas, Status status, Formato formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.status = status;
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFormato() {
        return String.valueOf(formato);
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }


    @Override
    public String toString() {
        /* FALTA
         * numero do id
         * */
        return "Livro{" +
                "ID = " + id +
                " titulo = '" + titulo + '\'' +
                ", autor = '" + autor + '\'' +
                ", páginas = " + paginas +
                ", status = " + status +
                ", formato = " + formato +
                '}';
    }
}
