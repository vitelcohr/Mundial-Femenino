import java.util.Scanner;

/**
 * Clase principal para ejecutar el programa de venta de boletos del Mundial Femenino de Fútbol.
 */
public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Configurar los elementos iniciales
        System.out.println("Ingrese el nombre del estadio:");
        String stadiumName = scanner.nextLine();

        System.out.println("Ingrese la capacidad total del estadio:");
        int totalCapacity = scanner.nextInt();

        // Usar la fecha actual para la venta (formato mmAAAAdd)
        String saleDate = "20240724";  // Puedes cambiar esto por la fecha actual usando una biblioteca de fechas

        Stadium stadium = new Stadium(stadiumName, totalCapacity, saleDate);
        TicketManager ticketManager = new TicketManager(stadium);

        boolean running = true;
        while (running) 
        {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Comprar boletos");
            System.out.println("2. Consultar disponibilidad total");
            System.out.println("3. Consultar disponibilidad individual");
            System.out.println("4. Reporte de caja");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (option) 
            {
                case 1:
                    // Comprar boletos
                    System.out.println("Ingrese su nombre:");
                    String buyerName = scanner.nextLine();

                    System.out.println("Ingrese su teléfono:");
                    String buyerPhone = scanner.nextLine();

                    System.out.println("Ingrese la cantidad de boletos a comprar (máximo 6):");
                    int quantity = scanner.nextInt();

                    System.out.println("Ingrese su presupuesto máximo:");
                    double budget = scanner.nextDouble();

                    System.out.println("Seleccione la localidad (1, 5 o 10):");
                    int localidad = scanner.nextInt();

                    String result = ticketManager.addBuyer(buyerName, buyerPhone, quantity, budget, localidad);
                    System.out.println(result);
                    break;

                case 2:
                    // Consultar disponibilidad total
                    System.out.println(ticketManager.consultarDisponibilidadTotal());
                    break;

                case 3:
                    // Consultar disponibilidad individual
                    System.out.println("Ingrese la localidad a consultar (1, 5 o 10):");
                    int loc = scanner.nextInt();
                    System.out.println(ticketManager.consultarDisponibilidadIndividual(loc));
                    break;

                case 4:
                    // Reporte de caja
                    double totalRevenue = ticketManager.reporteDeCaja();
                    System.out.println("Total generado: $" + totalRevenue);
                    break;

                case 5:
                    // Salir
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}

