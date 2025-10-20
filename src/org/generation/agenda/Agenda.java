package org.generation.agenda;

public class Agenda {
    private Contacto[] contactos;
    private int contadorContactos;

    // Constructor con tamaño por defecto (10)
    public Agenda() {
        this.contactos = new Contacto[10];
        this.contadorContactos = 0;
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamaño) {
        this.contactos = new Contacto[tamaño];
        this.contadorContactos = 0;
    }

    // Añadir contacto
    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("No se puede añadir. La agenda está llena.");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("No se puede añadir. El contacto ya existe.");
            return;
        }

        contactos[contadorContactos] = c;
        contadorContactos++;
        System.out.println("Contacto añadido correctamente.");
    }

    // Verificar si existe un contacto
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < contadorContactos; i++) {
            if (contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    // Listar todos los contactos
    public void listarContactos() {
        if (contadorContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("\nLISTA DE CONTACTOS");
        for (int i = 0; i < contadorContactos; i++) {
            System.out.println((i + 1) + ". " + contactos[i]);
        }
    }

    // Buscar contacto por nombre
    public void buscaContacto(String nombre) {
        for (int i = 0; i < contadorContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:\n" + contactos[i]);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Eliminar contacto
    public void eliminarContacto(Contacto c) {
        for (int i = 0; i < contadorContactos; i++) {
            if (contactos[i].equals(c)) {
                // Mover todos los contactos una posición hacia atrás
                for (int j = i; j < contadorContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[contadorContactos - 1] = null;
                contadorContactos--;
                System.out.println("Contacto eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se pudo eliminar. El contacto no existe.");
    }

    // Verificar si la agenda está llena
    public boolean agendaLlena() {
        return contadorContactos == contactos.length;
    }

    // Espacios libres disponibles
    public int espaciosLibres() {
        return contactos.length - contadorContactos;
    }
}