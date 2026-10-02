package vallegran.edu.pe.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegran.edu.pe.model.Productor;
import vallegran.edu.pe.model.ProductorDAO;

public class MainController {
    @FXML private TableView<Productor> tableUsuarios;
    @FXML private TableColumn<Productor, Integer> colId;
    @FXML private TableColumn<Productor, String> colNombre;
    @FXML private TableColumn<Productor, String> colApellido;
    @FXML private TableColumn<Productor, String> colCorreo;
    @FXML private TableColumn<Productor, String> colEstado;

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtCorreo;
    @FXML private ComboBox<String> cbEstado;
    @FXML private Button btnGuardar;

    private ProductorDAO productorDAO = new ProductorDAO();

    @FXML
    public void initialize() {
        // Enlazar las columnas con las propiedades del modelo Productor
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        // Asegúrate de que tu modelo Productor tenga estas propiedades (apellido, correo, estado)
        // o adáptalas según los atributos de tu clase Productor:
        // colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        // colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        // colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Cargar los datos en la tabla
        ObservableList<Productor> datos = productorDAO.listarProductores();
        tableUsuarios.setItems(datos);
    }
}