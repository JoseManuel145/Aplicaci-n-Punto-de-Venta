package manuel.cruz.demoproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.models.Inventario;
import manuel.cruz.demoproyecto.models.RegistroTickets;
import manuel.cruz.demoproyecto.models.Venta;

import java.io.IOException;

public class App extends Application {
    private static final Inventario inventario = new Inventario();
    private static final RegistroTickets registroTickets = new RegistroTickets();
    private static final Venta venta = new Venta();

    public static Inventario getInventario() {
        return inventario;
    }
    public static RegistroTickets getRegistroTickets() {
        return registroTickets;
    }
    public static Venta getVenta() {
        return venta;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-principal.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Estrella Eterna Store");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void nuevaVentana(MouseEvent event, String fxmlFile, String stageTitle) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFile + ".fxml"));

        try {
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle(stageTitle);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }
    public static void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public static void main(String[] args) {
        launch();
    }
}