import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la venta de tickets.
 */
public class TicketManager 
{
    private Stadium stadium;
    private List<Ticket> soldTickets;
    private int ticketCounter;

    /**
     * Constructor para la clase TicketManager.
     *
     * @param stadium El estadio donde se venden los boletos.
     */
    public TicketManager(Stadium stadium) 
    {
        this.stadium = stadium;
        this.soldTickets = new ArrayList<>();
        this.ticketCounter = 1;
    }

    /**
     * Agrega un nuevo comprador y genera los tickets.
     *
     * @param buyerName    Nombre del comprador.
     * @param buyerPhone   Teléfono del comprador.
     * @param quantity     Cantidad de boletos a comprar.
     * @param budget       Presupuesto máximo del comprador.
     * @param localidad    Localidad seleccionada.
     * @return Los tickets generados o un mensaje de error si no se puede realizar la compra.
     */
    public String addBuyer(String buyerName, String buyerPhone, int quantity, double budget, int localidad) 
    {
        double price = getPriceForLocalidad(localidad);
        if (price > budget) 
        {
            return "El precio excede su presupuesto.";
        }
        int availableTickets = getAvailableTickets(localidad);
        int ticketsToSell = Math.min(quantity, availableTickets);
        if (ticketsToSell == 0) 
        {
            return "No hay boletos disponibles en la localidad seleccionada.";
        }

        StringBuilder ticketInfo = new StringBuilder();
        for (int i = 0; i < ticketsToSell; i++) 
        {
            String ticketNumber = generateTicketNumber();
            Ticket ticket = new Ticket(ticketNumber, buyerName, buyerPhone, 1, price);
            soldTickets.add(ticket);
            ticketInfo.append(ticketNumber).append("\n");
            ticketCounter++;
        }
        stadium.reduceCapacity(localidad, ticketsToSell);
        return "Tickets generados:\n" + ticketInfo.toString();
    }

    /**
     * Genera el número del ticket usando la fecha de venta y el correlativo.
     *
     * @return El número del ticket generado.
     */
    private String generateTicketNumber() 
    {
        return stadium.getSaleDate() + String.format("%03d", ticketCounter);
    }

    /**
     * Obtiene el precio de los boletos para la localidad seleccionada.
     *
     * @param localidad La localidad seleccionada.
     * @return El precio de los boletos.
     */
    private double getPriceForLocalidad(int localidad) 
    {
        switch (localidad) 
        {
            case 1:
                return 250;
            case 5:
                return 575;
            case 10:
                return 1720;
            default:
                return 0;
        }
    }

    /**
     * Obtiene la cantidad de boletos disponibles en la localidad seleccionada.
     *
     * @param localidad La localidad seleccionada.
     * @return La cantidad de boletos disponibles.
     */
    private int getAvailableTickets(int localidad)
    {
        switch (localidad) 
        {
            case 1:
                return stadium.getCapacityLocalidad1();
            case 5:
                return stadium.getCapacityLocalidad5();
            case 10:
                return stadium.getCapacityLocalidad10();
            default:
                return 0;
        }
    }

    /**
     * Consulta la disponibilidad total de boletos en todas las localidades.
     *
     * @return Un reporte de la disponibilidad total de boletos.
     */
    public String consultarDisponibilidadTotal() 
    {
        return "Disponibilidad Total:\n" +
                "Localidad 1: " + stadium.getCapacityLocalidad1() + "\n" +
                "Localidad 5: " + stadium.getCapacityLocalidad5() + "\n" +
                "Localidad 10: " + stadium.getCapacityLocalidad10() + "\n";
    }

    /**
     * Consulta la disponibilidad de boletos en una localidad específica.
     *
     * @param localidad La localidad seleccionada.
     * @return La disponibilidad de boletos en la localidad seleccionada.
     */
    public String consultarDisponibilidadIndividual(int localidad) 
    {
        return "Disponibilidad en Localidad " + localidad + ": " + getAvailableTickets(localidad) + "\n";
    }

    /**
     * Genera un reporte de la caja.
     *
     * @return El monto total generado por la venta de boletos.
     */
    public double reporteDeCaja() 
    {
        return soldTickets.stream().mapToDouble(Ticket::getPrice).sum();
    }
}
