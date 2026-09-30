package vallegran.edu.pe.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegran.edu.pe.model.Productor;
import vallegran.edu.pe.model.ProductorDAO;

public class MainController {
    @FXML private TableView<Productor> tablaProductores;
    @FXML private TableColumn<Productor, Integer> colId;
    @FXML private TableColumn<Productor, String> colNombre;
    @FXML private TableColumn<Productor, String> colRegion;

    private ProductorDAO productorDAO = new ProductorDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRegion.setCellValueFactory(new PropertyValueFactory<>("region"));

        ObservableList<Productor> datos = productorDAO.listarProductores();
        tablaProductores.setItems(datos);
    }
}