package org.example.dao;

import org.example.ConnectionFactory;
import org.example.model.Livro;
import org.example.model.enums.Formato;
import org.example.model.enums.Status;

import java.sql.*;
import java.sql.Connection;


public class LivroDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement prepared;
    ResultSet resultSet; //É uma classe para receber informações que foram buscadas no banco de dados

    public void salva(Livro livro) {
        String sql = "INSERT INTO livro(nome, autor, paginas, status, formato) values (?,?,?,?,?)";
        //cada ponto de interrogação equivale a uma posição que coloquei abaixo
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

    public Livro buscaLivro(String titulo){
        Livro livro  = new Livro();
        try {
            prepared = connection.prepareStatement("SELECT * FROM livro WHERE nome = ?"); // criando um comando set incompleto
            prepared.setString(1, titulo); // adicionando o completo para subistituir o ponto de interrogação
            resultSet = prepared.executeQuery();
            if(resultSet.next()){ //ele verifica se a consulta encontrou o livro com o titulo informado
                //se encontrou o livro, carrega os dados
                livro.setTitulo(resultSet.getString("nome"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setPaginas(resultSet.getInt("paginas"));
                livro.setStatus(Status.valueOf(resultSet.getString("status")));
                // livro.setFormato(Formato.valueOf(resultSet.getString("formato")));

                return livro;
            }else{
                System.out.println("Livro não encontrado");
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro listaTudo() {
        String sql = "SELECT * FROM LIVRO";
        return null;
    }
}

