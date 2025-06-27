package org.example.model;

import org.example.model.enums.Formato;
import org.example.model.enums.Status;

import java.util.EnumSet;

public class Fisico extends Livro {
    public Fisico(String titulo, String autor, int paginas, Status status) {
        super(titulo, autor, paginas, status, Formato.FISICO);
    }
}
