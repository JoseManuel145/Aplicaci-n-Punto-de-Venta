package manuel.cruz.demoproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.models.Inventario;
import manuel.cruz.demoproyecto.models.Ticket;
import manuel.cruz.demoproyecto.models.Venta;

import java.io.IOException;

public class App extends Application {
    private static Inventario inventario = new Inventario();
    public static Inventario getInventario() {
        return inventario;
    }
    private static Venta venta = new Venta(inventario);

    public static Venta getVenta() {
        return venta;
    }
    private static Ticket ticket = new Ticket();

    public static Ticket getTicket() {
        return ticket;
    }

    private static Stage stageRoot;
    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-principal.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Tienda de la esquina");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void newStage(String fxml, String title) {
        Stage stageView = new Stage();
        Scene scene;
        try {
            scene = new Scene(loadFXML(fxml));
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Parent loadFXML(String fxml) throws IOException {  //Mandar a llamar las interfaces
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
}