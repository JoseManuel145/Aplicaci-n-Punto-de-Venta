package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.ProductoHogar;

public class AgregarHogarController {

    @FXML
    private Button AgregarButton;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button volverButton;

    public void onMouseClickedCrearButton(MouseEvent event){
        Producto productoBeta = new Producto();

        String id = productoBeta.genId();
        String name = txtName.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        String categoria = txtCategoria.getText();

        ProductoHogar hogar = new ProductoHogar(id, name, cantidad, precio, categoria);
        App.getInventario().addProduct(hogar);
    }

    public void onMouseClickedVolverButton(MouseEvent event){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
