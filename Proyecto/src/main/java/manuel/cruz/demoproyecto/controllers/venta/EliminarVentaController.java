package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;

public class EliminarVentaController {

    @FXML
    private Button elimPVentaButton;

    @FXML
    private TextField txtElimId;

    @FXML
    private Button volverButton;
    public void onMouseClickedAgregarButton(){
        String id = txtElimId.getText();
        App.getVenta().eliminarProducto(id);
    }

    public void onMouseClickedVolverButton(){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}