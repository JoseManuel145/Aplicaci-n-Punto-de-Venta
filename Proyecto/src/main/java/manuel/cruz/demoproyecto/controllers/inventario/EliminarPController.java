package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;

public class EliminarPController {

    @FXML
    private Button eliminarButton;

    @FXML
    private TextField txtIdEliminar;

    @FXML
    private Button volverButton;
    public void onMouseClickedEliminarButton(MouseEvent event){
        String id = txtIdEliminar.getText();
        App.getInventario().delProducto(id);
    }

    public void onMouseClickedVolverButton(MouseEvent event){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
