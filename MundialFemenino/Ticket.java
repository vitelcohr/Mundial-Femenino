/**
 * Clase que representa un ticket.
 */
public class Ticket 
{
    private String ticketNumber;
    private String buyerName;
    private String buyerPhone;
    private int quantity;
    private double price;

    /**
     * Constructor para la clase Ticket.
     *
     * @param ticketNumber Número del ticket.
     * @param buyerName    Nombre del comprador.
     * @param buyerPhone   Teléfono del comprador.
     * @param quantity     Cantidad de boletos.
     * @param price        Precio del boleto.
     */
    public Ticket(String ticketNumber, String buyerName, String buyerPhone, int quantity, double price) 
    {
        this.ticketNumber = ticketNumber;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.quantity = quantity;
        this.price = price;
    }

    // Métodos getter

    public String getTicketNumber() 
    {
        return ticketNumber;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }

    public String getBuyerPhone() 
    {
        return buyerPhone;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }
}
