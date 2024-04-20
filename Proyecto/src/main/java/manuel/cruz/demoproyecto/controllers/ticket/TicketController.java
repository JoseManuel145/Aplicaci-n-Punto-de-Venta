package manuel.cruz.demoproyecto.controllers.ticket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.RegistroTickets;
import manuel.cruz.demoproyecto.models.Ticket;
import java.util.ArrayList;

public class TicketController {
    @FXML
    private ListView <String> listTicket;
    @FXML
    private Button mostrarTicketButton;
    @FXML
    private Button volverButton;

    public void onMouseClickedMostrarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/ticket/buscar-ticket", "Busca un Ticket");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/menu-principal", "Menu principal");
    }
    @FXML
    public void initialize() {
        RegistroTickets registroTickets = App.getRegistroTickets();
        for (Ticket ticket: App.getRegistroTickets().getTickets()){
            listTicket.getItems().add(registroTickets.imprimirTicket(ticket));
        }
    }
}
