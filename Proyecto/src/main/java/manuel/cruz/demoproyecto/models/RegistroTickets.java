package manuel.cruz.demoproyecto.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RegistroTickets {
    ArrayList <Ticket> tickets = new ArrayList<>();
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    public void agregarTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public String imprimirTicket(Ticket ticket) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return ticket.getId() + "   " + dtf.format(ticket.getFechaCreacion()) + "    $" + ticket.getTotal();
    }
    public String imprimirTicketConPrecio(Ticket ticket) {
        StringBuilder ticketInfo = new StringBuilder();
        ticketInfo.append("Título: Ticket de Venta\n");
        ticketInfo.append("ID del Ticket: ").append(ticket.getId()).append("\n");
        ticketInfo.append("Productos Vendidos:\n");
        for (Producto producto : ticket.getProductosVendidos()) {
            ticketInfo.append("- ").append(producto.getNombre()).append(" - Precio: $").append(producto.getPrecio()).append("\n");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        ticketInfo.append("Fecha de creación: ").append(dtf.format(ticket.getFechaCreacion())).append("\n");
        ticketInfo.append("Total: $").append(ticket.getTotal()).append("\n");

        return ticketInfo.toString();
    }
}
