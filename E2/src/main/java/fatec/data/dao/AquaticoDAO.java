package fatec.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Aquatico;
import fatec.data.DatabaseConnection;

public class AquaticoDAO {

    public static void create(Aquatico aquatico) throws SQLException {
        String sql = "insert into aquatico (nome, idade, peso, vive_em_aguas_salgadas) values (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aquatico.getNome());
            stmt.setInt(2, aquatico.getIdade());
            stmt.setDouble(3, aquatico.getPeso());
            stmt.setBoolean(4, aquatico.isViveEmAguasSalgadas());
            stmt.executeUpdate();
        }
    }

    public static List<Aquatico> getAll() throws SQLException {
        String sql = "select * from aquatico";
        List<Aquatico> aquáticos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aquatico aquatico = new Aquatico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getDouble("peso"),
                    rs.getBoolean("vive_em_aguas_salgadas")
                );
                aquáticos.add(aquatico);
            }
        }
        return aquáticos;
    }

    public static Aquatico getById(int id) throws SQLException {
        String sql = "select * from aquatico where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Aquatico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("peso"),
                        rs.getBoolean("vive_em_aguas_salgadas")
                    );
                }
            }
        }
        return null;
    }

    public static void update(Aquatico aquatico) throws SQLException {
        String sql = "update aquatico set nome = ?, idade = ?, peso = ?, vive_em_aguas_salgadas = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aquatico.getNome());
            stmt.setInt(2, aquatico.getIdade());
            stmt.setDouble(3, aquatico.getPeso());
            stmt.setBoolean(4, aquatico.isViveEmAguasSalgadas());
            stmt.setInt(5, aquatico.getId());
            stmt.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from aquatico where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
