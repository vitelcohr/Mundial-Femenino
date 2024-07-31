/**
 * Clase que representa un estadio.
 */
public class Stadium 
{
    private String name;
    private int totalCapacity;
    private int capacityLocalidad1;
    private int capacityLocalidad5;
    private int capacityLocalidad10;
    private String saleDate;

    /**
     * Constructor para la clase Stadium.
     *
     * @param name          Nombre del estadio.
     * @param totalCapacity Capacidad total del estadio.
     * @param saleDate      Fecha de venta de los boletos en formato mmAAAAdd.
     */
    public Stadium(String name, int totalCapacity, String saleDate) 
    {
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.capacityLocalidad1 = totalCapacity / 3;
        this.capacityLocalidad5 = totalCapacity / 3;
        this.capacityLocalidad10 = totalCapacity / 3;
        this.saleDate = saleDate;
    }

    // Métodos getter y setter

    public String getName() 
    {
        return name;
    }

    public int getTotalCapacity() 
    {
        return totalCapacity;
    }

    public int getCapacityLocalidad1() 
    {
        return capacityLocalidad1;
    }

    public int getCapacityLocalidad5() 
    {
        return capacityLocalidad5;
    }

    public int getCapacityLocalidad10() 
    {
        return capacityLocalidad10;
    }

    public String getSaleDate() 
    {
        return saleDate;
    }

    public void reduceCapacity(int localidad, int ticketsSold) 
    {
        switch (localidad) 
        {
            case 1:
                capacityLocalidad1 -= ticketsSold;
                break;
            case 5:
                capacityLocalidad5 -= ticketsSold;
                break;
            case 10:
                capacityLocalidad10 -= ticketsSold;
                break;
        }
    }
}
