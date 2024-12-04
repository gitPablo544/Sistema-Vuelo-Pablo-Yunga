import java.util.Scanner;

public class PabloEstebanYungaOtavalo_Fp_Taller2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        int asientosDisponible = 100; // El avión tiene 100 asientos disponibles
        int limiteTiempo = 24; // Horas límite para reservas, cambios o cancelaciones
        double cantidadEquipajePermitida = 2; // Máximo número de maletas permitido
        double pesoEquipajePermitido = 23.5; // Peso máximo por maleta en kg
        boolean rebootSystem = true;

        while (rebootSystem) {
            System.out.println("BIENVENIDO AEROLINE \"SKY\"");

            // Validar nombres y apellidos
            String nombre;
            do {
                System.out.print("Ingrese sus nombres y apellidos: ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty() || !nombre.matches("[a-zA-Z ]+")) {
                    System.out.println("Entrada inválida. Solo se permiten letras y espacios.");
                }
            } while (nombre.trim().isEmpty() || !nombre.matches("[a-zA-Z ]+"));

            // Validar documento de identidad
            String documentoID;
            do {
                System.out.print("Ingrese documento de identidad: ");
                documentoID = scanner.nextLine();
                if (!documentoID.matches("\\d+")) {
                    System.out.println("Entrada inválida. Solo se permiten números.");
                }
            } while (!documentoID.matches("\\d+"));

            // Validar teléfono
            String telefono;
            do {
                System.out.print("Ingrese su teléfono: ");
                telefono = scanner.nextLine();
                if (!telefono.matches("\\d{10}")) {
                    System.out.println("Entrada inválida. El teléfono debe tener 10 dígitos.");
                }
            } while (!telefono.matches("\\d{10}"));

            // Validar correo electrónico
            String correo;
            do {
                System.out.print("Ingrese su correo electrónico: ");
                correo = scanner.nextLine();
                if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    System.out.println("Entrada inválida. Ingrese un correo electrónico válido.");
                }
            } while (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));

            // Opciones de viaje
            int lugar = 0;
            double precioBoleto = 0;

            while (true) {
                System.out.println("Ingrese el lugar a donde desea viajar:");
                System.out.println("1. Estados Unidos    500$");
                System.out.println("2. México            300$");
                System.out.println("3. Salvador          200$");
                System.out.println("4. Colombia          100$");
                System.out.println("5. Argentina         350$");
                System.out.print("Ingrese una opción válida (1-5): ");

                if (scanner.hasNextInt()) {
                    lugar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (lugar >= 1 && lugar <= 5) {
                        switch (lugar) {
                            case 1:
                                precioBoleto = 500;
                                System.out.println("Lugar de viaje a: Estados Unidos");
                                break;
                            case 2:
                                precioBoleto = 300;
                                System.out.println("Lugar de viaje a: México");
                                break;
                            case 3:
                                precioBoleto = 200;
                                System.out.println("Lugar de viaje a: Salvador");
                                break;
                            case 4:
                                precioBoleto = 100;
                                System.out.println("Lugar de viaje a: Colombia");
                                break;
                            case 5:
                                precioBoleto = 350;
                                System.out.println("Lugar de viaje a: Argentina");
                                break;
                        }
                        break;
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 5.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Limpia la entrada incorrecta
                }
            }

            // Opciones de acciones
            int opcion = 0;
            double multa = 0;
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Realizar reserva");
                System.out.println("2. Cambiar reserva");
                System.out.println("3. Cancelar reserva");
                System.out.print("Ingrese una opción válida (1-3): ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (opcion >= 1 && opcion <= 3) {
                        switch (opcion) {
                            case 1:
                                if (asientosDisponible > 0) {
                                    asientosDisponible--;
                                    System.out.println("Reserva realizada exitosamente. Asientos restantes: " + asientosDisponible);
                                } else {
                                    System.out.println("No hay asientos disponibles.");
                                }
                                break;

                            case 2:
                                System.out.print("Ingrese el tiempo (en horas) antes del vuelo para el cambio: ");
                                int horasCambio = scanner.nextInt();
                                scanner.nextLine(); // Limpia el buffer
                                if (horasCambio <= limiteTiempo) {
                                    System.out.println("Cambio realizado con éxito.");
                                } else {
                                    System.out.println("No es posible realizar el cambio.");
                                }
                                break;

                            case 3:
                                System.out.print("Ingrese el tiempo (en horas) antes del vuelo para la cancelación: ");
                                int horasCancelacion = scanner.nextInt();
                                scanner.nextLine(); // Limpia el buffer
                                if (horasCancelacion >= limiteTiempo) {
                                    System.out.println("Cancelación realizada sin cargos.");
                                } else {
                                    multa = precioBoleto * 0.20;
                                    System.out.println("Cancelación realizada. Se aplicará una multa de: $" + multa);
                                }
                                break;
                        }
                        break;
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 3.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Limpia la entrada incorrecta
                }
            }


            int cantidadMaletas = 0;
            // Validar cantidad de maletas
            while (true) {

                System.out.print("Ingrese la cantidad de maletas: ");
                if (scanner.hasNextInt()) {

                    cantidadMaletas = scanner.nextInt();
                    
                    if (cantidadMaletas >= 0) { // La cantidad de maletas debe ser positiva
                        break;
                    } else {
                        System.out.println("Por favor, ingrese un número válido de maletas (debe ser positivo).");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scanner.next(); // Limpiar el buffer de entrada
                }
            }


            if (cantidadMaletas <= cantidadEquipajePermitida) {

                double pesoMaleta = 0;
                // Validar peso de cada maleta

                while (true) {

                    System.out.print("Ingrese el peso de cada maleta: ");

                    if (scanner.hasNextDouble()) {

                        pesoMaleta = scanner.nextDouble();

                        if (pesoMaleta >= 0) { // El peso debe ser positivo
                            break;
                    } else {

                        System.out.println("Por favor, ingrese un peso válido (debe ser numero entero positivo).");
                    }
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                        scanner.next(); // Limpiar el buffer de entrada
                    }
                }


                if (pesoMaleta <= pesoEquipajePermitido) {
                    System.out.println("Equipaje aceptado.");
                    double total = precioBoleto + multa;
                    System.out.println("Total a pagar: $" + total);
                } else {
                    System.out.println("Peso excedido. No se permite el equipaje.");
                }
            } else {
                System.out.println("Cantidad de equipaje excedida.");
            }

            // Continuar o terminar
            System.out.print("¿Desea continuar para agendar otro vuelo? (si/no): ");
            scanner.nextLine(); // Limpiar el buffer
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                rebootSystem = false;
                System.out.println("Gracias por preferirnos.");
            }
        }
        scanner.close();
    }
}
