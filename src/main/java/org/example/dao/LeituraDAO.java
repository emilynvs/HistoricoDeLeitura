package org.example.dao;

import org.example.ConnectionFactory;
import org.example.model.Leitura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeituraDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement prepared;
    ResultSet resultSet;

    public void  salva(Leitura leitura){
        String sql = "INSERT INTO leitura(id_livro, data_inicio, paginas_lidas, nota, comentario, releitura) values(?,?,?,?,?,?)";
        try{
            prepared = connection.prepareStatement(sql);
            prepared.setInt(1, leitura.getIdLivro());
            prepared.setString(2, String.valueOf(leitura.getDataInicio()));
            prepared.setInt(3, leitura.getPaginasLidas());
            prepared.setInt(4, leitura.getNota());
            prepared.setString(5, leitura.getComentario());
            prepared.setBoolean(6, leitura.isReleitura());
            prepared.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void  atualiza(){

    }
    public void  deleta(){
    }
    public void exibe(){
    }
    public Leitura listaTudo(){
        return null;
    }
}
