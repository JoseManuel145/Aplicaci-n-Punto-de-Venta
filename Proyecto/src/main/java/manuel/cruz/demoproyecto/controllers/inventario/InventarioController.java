package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Inventario;
import manuel.cruz.demoproyecto.models.Producto;


public class InventarioController {
    @FXML
    private ListView<String> listProduct;

    @FXML
    private Button agregarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private Button volverButton;
    @FXML
    public void initialize() {
        Inventario inventario = App.getInventario();

        listProduct.getItems().clear();

        for (Producto producto : inventario.getProductos()) {
            listProduct.getItems().add(producto.toString());
        }
    }

    public void onMouseClickedAgregarButton(MouseEvent event){
        App.newStage("/manuel/cruz/demoproyecto/inventario/agregarP-inventario", "Categoria del producto");
    }
    public void onMouseClickedEliminarButton(MouseEvent event){
        App.newStage("/manuel/cruz/demoproyecto/inventario/eliminarP-inventario", "Categoria del producto");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
