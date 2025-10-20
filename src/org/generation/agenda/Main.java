package org.generation.agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar capacidad de la agenda
        System.out.print("¿Cuántos contactos quieres en tu agenda? (presiona Enter para 10 por defecto): ");
        String entrada = scanner.nextLine();

        Agenda agenda;
        if (entrada.isEmpty()) {
            agenda = new Agenda(); // Tamaño por defecto (10)
            System.out.println("Agenda creada con capacidad de 10 contactos.");
        } else {
            int capacidad = Integer.parseInt(entrada);
            agenda = new Agenda(capacidad);
            System.out.println("Agenda creada con capacidad de " + capacidad + " contactos.");
        }

        int opcion;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Opción inválida
            }

            switch (opcion) {
                case 1:
                    añadirContacto(scanner, agenda);
                    break;
                case 2:
                    buscarContacto(scanner, agenda);
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    eliminarContacto(scanner, agenda);
                    break;
                case 5:
                    verificarEspacio(agenda);
                    break;
                case 6:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMENU AGENDA");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Listar contactos");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Ver espacios disponibles");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void añadirContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Contacto contacto = new Contacto(nombre, telefono);
        agenda.añadirContacto(contacto);
    }

    private static void buscarContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        agenda.buscaContacto(nombre);
    }

    private static void eliminarContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();
        Contacto contacto = new Contacto(nombre, "");
        agenda.eliminarContacto(contacto);
    }

    private static void verificarEspacio(Agenda agenda) {
        if (agenda.agendaLlena()) {
            System.out.println("La agenda está llena.");
        } else {
            System.out.println("Espacios libres: " + agenda.espaciosLibres());
        }
    }
}