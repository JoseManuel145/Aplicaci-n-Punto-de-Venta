package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;

public class AgregarVenta {

    @FXML
    private Button agregaPButton;
    @FXML
    private TextField txtId;
    @FXML
    private Button volverButton;
    public void onMouseClickedAgregarButton(){
        String id = txtId.getText();
        App.getVenta().agregarProducto(id);
    }

    public void onMouseClickedVolverButton(){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
