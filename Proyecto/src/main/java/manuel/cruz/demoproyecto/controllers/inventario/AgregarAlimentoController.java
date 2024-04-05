package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.ProductoAlimento;

public class AgregarAlimentoController {

    @FXML
    private Button AgregarButton;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button volverButton;
    public void onMouseClickedVolverButton(){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
    public void onMouseClickedAgregarButton(){
        Producto productoBeta = new Producto();

        String id = productoBeta.genId();
        String nombre = txtName.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String caducidad = txtFecha.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        ProductoAlimento alimento = new ProductoAlimento(id,nombre,cantidad,precio,caducidad);
        App.getInventario().addProduct(alimento);
    }
}
