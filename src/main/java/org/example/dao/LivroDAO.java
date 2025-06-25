package org.example.dao;

import org.example.ConnectionFactory;
import org.example.model.Livro;

import java.sql.*;
import java.sql.Connection;


public class LivroDAO {
    Connection connection = ConnectionFactory.getConnection();

    public void salva(Livro livro) {
        String sql = "INSERT INTO livro(nome, autor, paginas, status, formato) values (?,?,?,?,?)";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, livro.getTitulo());
            prepared.setString(2, livro.getAutor());
            prepared.setInt(3, livro.getPaginas());
            prepared.setString(4, livro.getStatus());
            prepared.setString(5, livro.getFormato());

            prepared.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void atualiza() {

    }


    public void excui() {

    }


    public Livro listaTudo() {

        return null;
    }
}

