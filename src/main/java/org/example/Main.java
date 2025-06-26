package org.example;

import org.example.dao.LivroDAO;
import org.example.model.Fisico;
import org.example.model.Livro;
import org.example.model.enums.Status;

import java.sql.SQLException;

public class Main {

        public static void main(String[] args) throws SQLException {
                LivroDAO dao = new LivroDAO();
               //Livro livro = new Fisico("E Não Sobrou Nenhum", "Agatha Chrstie", 400, Status.LI);
                // dao.salva(livro);

               System.out.println(dao.buscaLivro("o cortiço"));
        }

}