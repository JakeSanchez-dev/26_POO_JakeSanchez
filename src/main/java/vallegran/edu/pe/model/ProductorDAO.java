package vallegran.edu.pe.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vallegran.edu.pe.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductorDAO {

    // S09: SELECT
    public ObservableList<Productor> listarProductores() {
        ObservableList<Productor> lista = FXCollections.observableArrayList();
        String sql = "SELECT id, nombre, region FROM productor";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Productor prod = new Productor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("region")
                );
                lista.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // S10: INSERT
    public boolean insertar(Productor p) {
        String sql = "INSERT INTO productor (nombre, region) VALUES (?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getRegion());

            if (ps.executeUpdate() > 0) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) p.setId(keys.getInt(1));
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}