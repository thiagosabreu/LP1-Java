package fatec.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Caminhao;
import fatec.data.DatabaseConnection;

public class CaminhaoDAO {

    public static void create(Caminhao caminhao) throws SQLException {
        String sql = "insert into caminhao (marca, modelo, ano, peso, capacidade_carga) values (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getMarca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setInt(3, caminhao.getAno());
            stmt.setDouble(4, caminhao.getPeso());
            stmt.setDouble(5, caminhao.getCapacidadeCarga());
            stmt.executeUpdate();
        }
    }

    public static List<Caminhao> getAll() throws SQLException {
        String sql = "select * from caminhao";
        List<Caminhao> caminhoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Caminhao caminhao = new Caminhao(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getDouble("peso"),
                    rs.getDouble("capacidade_carga")
                );
                caminhoes.add(caminhao);
            }
        }
        return caminhoes;
    }

    public static Caminhao getById(int id) throws SQLException {
        String sql = "select * from caminhao where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Caminhao(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getDouble("peso"),
                        rs.getDouble("capacidade_carga")
                    );
                }
            }
        }
        return null;
    }

    public static void update(Caminhao caminhao) throws SQLException {
        String sql = "update caminhao set marca = ?, modelo = ?, ano = ?, peso = ?, capacidade_carga = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getMarca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setInt(3, caminhao.getAno());
            stmt.setDouble(4, caminhao.getPeso());
            stmt.setDouble(5, caminhao.getCapacidadeCarga());
            stmt.setInt(6, caminhao.getId());
            stmt.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from caminhao where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
