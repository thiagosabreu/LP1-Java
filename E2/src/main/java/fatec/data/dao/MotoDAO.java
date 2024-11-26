package fatec.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Moto;
import fatec.data.DatabaseConnection;

public class MotoDAO {

    public static void create(Moto moto) throws SQLException {
        String sql = "insert into moto (marca, modelo, ano, peso, tem_carenagem) values (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setInt(3, moto.getAno());
            stmt.setDouble(4, moto.getPeso());
            stmt.setBoolean(5, moto.isTemCarenagem());
            stmt.executeUpdate();
        }
    }

    public static List<Moto> getAll() throws SQLException {
        String sql = "select * from moto";
        List<Moto> motos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Moto moto = new Moto(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getDouble("peso"),
                    rs.getBoolean("tem_carenagem")
                );
                motos.add(moto);
            }
        }
        return motos;
    }

    public static Moto getById(int id) throws SQLException {
        String sql = "select * from moto where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Moto(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getDouble("peso"),
                        rs.getBoolean("tem_carenagem")
                    );
                }
            }
        }
        return null;
    }

    public static void update(Moto moto) throws SQLException {
        String sql = "update moto set marca = ?, modelo = ?, ano = ?, peso = ?, tem_carenagem = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setInt(3, moto.getAno());
            stmt.setDouble(4, moto.getPeso());
            stmt.setBoolean(5, moto.isTemCarenagem());
            stmt.setInt(6, moto.getId());
            stmt.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from moto where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
