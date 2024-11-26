package fatec.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Felino;
import fatec.data.DatabaseConnection;

public class FelinoDAO {

    public static void create(Felino felino) throws SQLException {
        String sql = "insert into felino (nome, idade, peso, gosta_de_dormir) values (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, felino.getNome());
            stmt.setInt(2, felino.getIdade());
            stmt.setDouble(3, felino.getPeso());
            stmt.setBoolean(4, felino.isGostaDeDormir());
            stmt.executeUpdate();
        }
    }

    public static List<Felino> getAll() throws SQLException {
        String sql = "select * from felino";
        List<Felino> felinos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Felino felino = new Felino(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getDouble("peso"),
                    rs.getBoolean("gosta_de_dormir")
                );
                felinos.add(felino);
            }
        }
        return felinos;
    }

    public static Felino getById(int id) throws SQLException {
        String sql = "select * from felino where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Felino(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("peso"),
                        rs.getBoolean("gosta_de_dormir")
                    );
                }
            }
        }
        return null;
    }

    public static void update(Felino felino) throws SQLException {
        String sql = "update felino set nome = ?, idade = ?, peso = ?, gosta_de_dormir = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, felino.getNome());
            stmt.setInt(2, felino.getIdade());
            stmt.setDouble(3, felino.getPeso());
            stmt.setBoolean(4, felino.isGostaDeDormir());
            stmt.setInt(5, felino.getId());
            stmt.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from felino where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
