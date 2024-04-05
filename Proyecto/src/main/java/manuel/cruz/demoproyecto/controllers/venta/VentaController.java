package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.Ticket;
import manuel.cruz.demoproyecto.models.Venta;


public class VentaController {
    Ticket ticket = new Ticket();
    @FXML
    private TextField txtDineroIngreso;
    @FXML
    private Label cajaTotal;
    @FXML
    private ListView <String> productosVender;

    @FXML
    private Button agregPButton;

    @FXML
    private Button elimPButton;

    @FXML
    private Button venderButton;

    @FXML
    private Button volverButton;
    @FXML
    private Button actualizarButton;
    @FXML
    private TextField dineroIngresado;
    private Venta venta;
    public void onMouseClickedActualizarButton(){
        venta = App.getVenta();
        productosVender.getItems().clear();

        for (Producto productos: venta.getProductosVender()){
            productosVender.getItems().add(productos.productosEnVenta());
        }
        cajaTotal.setText("TOTAL: $" + venta.calcularTotal());
    }
    public void onMouseClickedAgregarButton(){
        App.newStage("/manuel/cruz/demoproyecto/venta/agregarP-venta", "Agrega un producto");
    }
    public void onMouseClickedVenderButton() {
        venta = App.getVenta();
        Ticket nuevoTicket = venta.finalizarVenta();
        App.getTicket().agregarTicket(nuevoTicket);

        String input =  txtDineroIngreso.getText();
        double dinero = Double.parseDouble(input);
        double cambio = dinero - venta.getTotal();
        System.out.println(cambio + "  " + venta.getTotal() + "  " + dinero);
        cajaTotal.setText("CAMBIO: $" + cambio);
        System.out.println(cambio);
    }


    public void onMouseClickedEliminarButton(){
        App.newStage("/manuel/cruz/demoproyecto/venta/eliminarP-venta", "Elimina un producto");
    }
    public void onMouseClickedVolverButton(){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }

}
