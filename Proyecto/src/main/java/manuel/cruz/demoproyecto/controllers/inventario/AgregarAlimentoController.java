package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.ProductoAlimento;

public class AgregarAlimentoController {
    @FXML
    private Button agregarButton;
    @FXML
    private Button volverButton;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/agregarP-inventario", "Elige tipo de producto");
    }
    public void onMouseClickedAgregarButton() {
        String nombre;
        String cantidadStr;
        String precioStr;
        String caducidad;

        nombre = txtName.getText();
        cantidadStr = txtCantidad.getText();
        caducidad = txtFecha.getText();
        precioStr = txtPrecio.getText();

        if (nombre.isEmpty() || cantidadStr.isEmpty() || caducidad.isEmpty() || precioStr.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Todos los campos son obligatorios.");
            return;
        }
        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser números válidos.");
            return;
        }

        if (cantidad <= 0 || precio <= 0) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser mayores que cero.");
            return;
        }

        Producto productoBeta = new Producto();
        String id = productoBeta.genId();
        ProductoAlimento alimento = new ProductoAlimento(id, nombre, cantidad, precio, caducidad);
        boolean productoAgregado = App.getInventario().addProduct(alimento);

        if (productoAgregado) {
            App.showAlert(Alert.AlertType.INFORMATION, "Producto Agregado", "El producto se agregó correctamente.");
        }
    }
}
