package org.example.dao;

import org.example.ConnectionFactory;
import org.example.model.Livro;
import org.example.model.enums.Formato;
import org.example.model.enums.Status;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Esqueci de colocar para exibir em buscaLivro, todos os livros que possuem o titulo inserido
 * */

public class LivroDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement prepared;
    ResultSet resultSet; //É uma classe para receber informações que foram buscadas no banco de dados

    public void salva(Livro livro) {
        String sql = "INSERT INTO livro(nome, autor, paginas, status, formato) values (?,?,?,?,?)";
        //cada ponto de interrogação equivale a uma posição que coloquei abaixo
        try {
            prepared = connection.prepareStatement(sql);
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

    public void excLui(int id) {
        try{
            prepared = connection.prepareStatement("DELETE FROM livro WHERE id = ?");
            prepared.setInt(1, id);
            prepared.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> buscaLivros(String titulo){
        Livro livro  = new Livro();
        ArrayList <String> livroArrayList = new ArrayList<>();
        try {
            prepared = connection.prepareStatement("SELECT * FROM livro WHERE nome = ?"); // criando um comando set incompleto
            prepared.setString(1, titulo); // adicionando o completo para subistituir o ponto de interrogação
            resultSet = prepared.executeQuery();
            while(resultSet.next()){ //ele verifica se a consulta encontrou o livro com o titulo informado
                //se encontrou o livro, carrega os dados
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("nome"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setPaginas(resultSet.getInt("paginas"));
                livro.setStatus(Status.valueOf(resultSet.getString("status")));
                livro.setFormato(Formato.valueOf(resultSet.getString("formato")));
                livroArrayList.add(String.valueOf(livro));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livroArrayList;
    }

    public Livro buscaLivro(String titulo){
        Livro livro  = new Livro();
        try {
            prepared = connection.prepareStatement("SELECT * FROM livro WHERE nome = ?"); // criando um comando set incompleto
            prepared.setString(1, titulo); // adicionando o completo para subistituir o ponto de interrogação
            resultSet = prepared.executeQuery();
            if (resultSet.next()){ //ele verifica se a consulta encontrou o livro com o titulo informado
                //se encontrou o livro, carrega os dados
                livro.setId(resultSet.getInt("id"));
                livro.setTitulo(resultSet.getString("nome"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setPaginas(resultSet.getInt("paginas"));
                livro.setStatus(Status.valueOf(resultSet.getString("status")));
                livro.setFormato(Formato.valueOf(resultSet.getString("formato")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livro;
    }

    public void listaTudo() throws SQLException {

        ArrayList <String> livroArrayList = new ArrayList<>();
        prepared = connection.prepareStatement("SELECT * FROM LIVRO");
        resultSet = prepared.executeQuery();
        while(resultSet.next()){
            String autor  = resultSet.getString("autor");
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("nome");
            int paginas = resultSet.getInt("paginas");
            Status status = Status.valueOf(resultSet.getString("status"));
            Formato formato =Formato.valueOf(resultSet.getString("formato"));

            Livro livro = new Livro(titulo, autor, paginas, status,formato);
            livro.setId(id);
            livroArrayList.add(String.valueOf(livro));
        }
        for (String livroString : livroArrayList) {
            System.out.println(livroString);
        }
    }
}

