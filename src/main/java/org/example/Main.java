package org.example;

import org.example.dao.LeituraDAO;
import org.example.dao.LivroDAO;
import org.example.model.Fisico;
import org.example.model.Leitura;
import org.example.model.Livro;
import org.example.model.enums.Status;
//esqueci de colocar a avaliação, notas e genero
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
                LivroDAO dao = new LivroDAO();
                LeituraDAO leituraDAO = new LeituraDAO();
                System.out.println(dao.buscaLivro("e não sobrou nenhum"));

        }

}