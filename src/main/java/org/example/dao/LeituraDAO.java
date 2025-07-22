package org.example.dao;

import org.example.ConnectionFactory;
import org.example.model.Leitura;
import org.example.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class LeituraDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement prepared;
    ResultSet resultSet;
    LivroDAO dao = new LivroDAO();

    public void salva(Leitura leitura) {
        String sql = "INSERT INTO leitura(id_livro, data_inicio, paginas_lidas, nota, comentario, releitura) values(?,?,?,?,?,?)";
        try {
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

    public void atualiza(int id, String coment, int pag) {
        String sql;
        boolean atualizaPaginas = pag > 0;

        if (atualizaPaginas) {
            sql = "UPDATE leitura SET comentario = ?, paginas_lidas = ? WHERE id = ?";
        } else {
            sql = "UPDATE leitura SET comentario = ? WHERE id = ?";
        }
        try {
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, coment);
            if (atualizaPaginas) {
                prepared.setInt(2, pag);
                prepared.setInt(3, id);
            } else {
                prepared.setInt(2, id);
            }
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleta(int id) {//recebe o id do histórico de leitura
        try {
            prepared = connection.prepareStatement("DELETE FROM leitura WHERE id = ?");
            prepared.setInt(1, id);
            prepared.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Leitura buscaLeitura(int id) {

        Leitura leitura = new Leitura();
        try {
            prepared = connection.prepareStatement("SELECT * FROM leitura WHERE id= ?");
            prepared.setInt(1, id);
            resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                leitura.setComentario(resultSet.getString("comentario"));
                leitura.setId(resultSet.getInt("id"));
                leitura.setIdLivro(resultSet.getInt("id_livro"));
                leitura.setPaginasLidas(resultSet.getInt("paginas_lidas"));
                return leitura;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public ArrayList<Leitura> exibeHistorico(String titulo) {
        Livro idLivro = dao.buscaLivro(titulo);
        ArrayList<Leitura> livros = new ArrayList<>();
        try {
            prepared = connection.prepareStatement("SELECT * FROM leitura WHERE id_livro = ?");
            prepared.setString(1, String.valueOf(idLivro.getId()));
            resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                Leitura leitura = new Leitura();
                leitura.setId(resultSet.getInt("id"));
                leitura.setIdLivro(resultSet.getInt("id_livro"));
                leitura.setPaginasLidas(resultSet.getInt("paginas_lidas"));
                leitura.setComentario(resultSet.getNString("comentario"));
                leitura.setDataInicio(LocalDate.parse(resultSet.getString("data_inicio")));
                livros.add(leitura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livros;

    }

    public void listaTudo() {
        ArrayList<Leitura> leituras = new ArrayList<>();
        try {
            prepared = connection.prepareStatement("SELECT * FROM leitura");
            resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                Leitura leitura = new Leitura();
                leitura.setIdLivro(resultSet.getInt("id_livro"));
                leitura.setId(resultSet.getInt("id"));
                leitura.setComentario(resultSet.getString("comentario"));
                leitura.setDataInicio(LocalDate.parse(resultSet.getString("data_inicio")));
                leitura.setReleitura(resultSet.getBoolean("releitura"));
                leitura.setNota(resultSet.getInt("nota"));
                leitura.setPaginasLidas(resultSet.getInt("paginas_lidas"));
                leituras.add(leitura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Leitura leitura: leituras){
            System.out.println(leitura);
        }
    }
}
