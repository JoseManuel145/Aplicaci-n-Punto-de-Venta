package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;

public class ProductoController {
    @FXML
    private Button alimentoButton;
    @FXML
    private Button hogarButton;
    @FXML
    private Button volverButton;
    public void onMouseClickedAlimentoButton(MouseEvent event){
        App.newStage("/manuel/cruz/demoproyecto/inventario/agregarP-alimento", "Alimentos");
    }
    public void onMouseClickedHogarButton(MouseEvent event){
        App.newStage("/manuel/cruz/demoproyecto/inventario/agregarP-hogar", "Hogar");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
