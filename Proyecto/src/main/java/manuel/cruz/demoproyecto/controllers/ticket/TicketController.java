package manuel.cruz.demoproyecto.controllers.ticket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Ticket;
import java.util.ArrayList;

public class TicketController {
    @FXML
    private ListView listTicket;

    @FXML
    private Button mostrarTicketButton;

    @FXML
    private Button volverButton;
    private ArrayList<Ticket> tickets;
    @FXML
    public void initialize() {
        tickets = App.getTicket().getTickets();
        for (Ticket ticket: tickets){
            listTicket.getItems().add(ticket.imprimirTicket());
        }
    }
    public void onMouseClickedMostrarButton(MouseEvent event){
        App.newStage("/manuel/cruz/demoproyecto/ticket/buscar-ticket", "Busca un Ticket");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
