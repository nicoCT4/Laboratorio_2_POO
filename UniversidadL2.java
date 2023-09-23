//Universidad del valle de Guatemala
//Carne:23197
//Fecha: 22/09/2023
//LAB 2
/**
 * Clase principal que ayuda a estructurar un horario
 */

import java.util.Scanner;

public class UniversidadL2 {
            /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Los argumentos de línea de comandos 
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema(); // Crear una instancia del sistema
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Consultar salón por medio del id del salón
                    consultarSalon(sistema, scanner);
                    break;
                case 2:
                    // Asignar salón a un curso
                    asignarSalonACurso(sistema, scanner);
                    break;
                case 3:
                    // Generar informe
                    sistema.generarInforme();
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 4.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nBienvenidos a LAB 2");
        System.out.println("1. Consultar salón por medio del id del salón");
        System.out.println("2. Asignar salón a un curso");
        System.out.println("3. Generar informe");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void consultarSalon(Sistema sistema, Scanner scanner) {
        System.out.println("Introduce el id de la sede:");
        int idSede = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Introduce el edificio:");
        char edificio = scanner.nextLine().charAt(0);

        System.out.println("Introduce el nivel:");
        int nivel = scanner.nextInt();

        System.out.println("Introduce el número de salón:");
        int idSalon = scanner.nextInt();

        Salon salon = sistema.consultarSalon(idSede, edificio, nivel, idSalon);
        if (salon != null) {
            // Mostrar información del salón
            System.out.println("Información del salón:");
            System.out.println("Sede: " + salon.getSede());
            System.out.println("Edificio: " + salon.getEdificio());
            System.out.println("Nivel: " + salon.getNivel());
            System.out.println("Número de salón: " + salon.getSalon());
            System.out.println("Capacidad: " + salon.getCapacidad());
        }
    }

    public static void asignarSalonACurso(Sistema sistema, Scanner scanner) {
        // Solicitar el ID del curso
        System.out.println("Introduce el ID del curso:");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
    
        // Solicitar el ID de la sede del curso
        System.out.println("Introduce el ID de la sede del curso:");
        int idSede = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
    
        // Buscar el curso y el salón correspondientes
        Curso curso = sistema.consultarCurso(idCurso);
        Salon salon = sistema.consultarSalonPorSede(idSede);
    
        if (curso != null && salon != null) {
            // Verificar si se puede asignar el curso al salón
            if (sistema.asignarCursoASalon(curso, salon)) {
                System.out.println("Curso asignado al salón con éxito.");
            } else {
                System.out.println("No se pudo asignar el curso al salón.");
            }
        }
    }
    
}
