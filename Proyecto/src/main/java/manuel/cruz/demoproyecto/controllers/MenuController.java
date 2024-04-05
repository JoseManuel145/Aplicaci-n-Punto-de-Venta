package manuel.cruz.demoproyecto.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button inventarioButton;

    @FXML
    private Button ticketsButton;

    @FXML
    private Button ventaButton;

    private Stage primaryStage;

    public void init(Stage stageRoot) {
        primaryStage = stageRoot;
    }

    @FXML
    void onMouseClickedInventarioButton() throws IOException { // Moverme a la interfaz de "Agregar Animales".
        App.newStage("/manuel/cruz/demoproyecto/inventario/menu-inventario","Inventario");
    }
    @FXML
    void onMouseClickedTicketButton() throws IOException {
        App.newStage("/manuel/cruz/demoproyecto/ticket/menu-ticket","Tickets");
    }
    @FXML
    void onMouseClickedVentaButton() throws IOException {
        App.newStage("/manuel/cruz/demoproyecto/venta/menu-venta","Punto de Venta");
    }
}
