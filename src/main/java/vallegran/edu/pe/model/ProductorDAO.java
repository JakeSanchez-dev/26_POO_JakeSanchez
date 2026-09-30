package vallegran.edu.pe.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vallegran.edu.pe.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductorDAO {
    public ObservableList<Productor> listarProductores() {
        ObservableList<Productor> lista = FXCollections.observableArrayList();
        // Nota: Asegúrate de que la tabla sea "productor" en singular
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
}