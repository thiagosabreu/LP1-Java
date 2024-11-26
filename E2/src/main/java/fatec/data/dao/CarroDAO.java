package fatec.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Carro;
import fatec.data.DatabaseConnection;

public class CarroDAO {

    public static void create(Carro carro) throws SQLException {
        String sql = "insert into carro (marca, modelo, ano, peso, quantidade_portas) values (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setDouble(4, carro.getPeso());
            stmt.setInt(5, carro.getQuantidadePortas());
            stmt.executeUpdate();
        }
    }

    public static List<Carro> getAll() throws SQLException {
        String sql = "select * from carro";
        List<Carro> carros = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Carro carro = new Carro(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getDouble("peso"),
                    rs.getInt("quantidade_portas")
                );
                carros.add(carro);
            }
        }
        return carros;
    }

    public static Carro getById(int id) throws SQLException {
        String sql = "select * from carro where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Carro(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade_portas")
                    );
                }
            }
        }
        return null;
    }

    public static void update(Carro carro) throws SQLException {
        String sql = "update carro set marca = ?, modelo = ?, ano = ?, peso = ?, quantidade_portas = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setDouble(4, carro.getPeso());
            stmt.setInt(5, carro.getQuantidadePortas());
            stmt.setInt(6, carro.getId());
            stmt.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from carro where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
