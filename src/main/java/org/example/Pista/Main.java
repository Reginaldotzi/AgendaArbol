package org.example.Pista;

import org.example.Modelo.Contacto;
import org.example.Servicio.Agenda;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Agregar contactos
        agenda.agregarContacto("Mario", 2345678L, "marioelpro69@gmail.com", LocalDate.of(1996, 12, 3));
        agenda.agregarContacto("Link", 987654321L, "linkhero@gmail.com", LocalDate.of(1986, 2, 21));
        agenda.agregarContacto("Peach", 456789123L, "peachprincess@gmail.com", LocalDate.of(1985, 10, 18));
        agenda.agregarContacto("Luigi", 321654987L, "luigiman@gmail.com", LocalDate.of(1990, 11, 17));
        agenda.agregarContacto("Zelda", 147258369L, "zeldaqueen@gmail.com", LocalDate.of(1986, 2, 21));
        agenda.agregarContacto("Toad", 963852741L, "toadbuddy@gmail.com", LocalDate.of(1985, 7, 9));
        agenda.agregarContacto("Bowser", 159753486L, "bowserboss@gmail.com", LocalDate.of(1985, 9, 13));
        agenda.agregarContacto("Yoshi", 258369147L, "yoshidino@gmail.com", LocalDate.of(1990, 8, 23));
        agenda.agregarContacto("Donkey Kong", 951753842L, "dkking@gmail.com", LocalDate.of(1981, 7, 9));
        agenda.agregarContacto("Diddy Kong", 753951486L, "diddyfriend@gmail.com", LocalDate.of(1994, 11, 18));
        agenda.agregarContacto("Kirby", 852147963L, "kirbysuck@gmail.com", LocalDate.of(1992, 4, 27));
        agenda.agregarContacto("Samus", 369258147L, "samusbounty@gmail.com", LocalDate.of(1986, 8, 6));
        agenda.agregarContacto("Fox", 159846753L, "foxfighter@gmail.com", LocalDate.of(1993, 2, 21));
        agenda.agregarContacto("Falco", 741852963L, "falcoace@gmail.com", LocalDate.of(1993, 2, 21));
        agenda.agregarContacto("Pikachu", 123987456L, "pikachuelectric@gmail.com", LocalDate.of(1996, 2, 27));
        agenda.agregarContacto("Jigglypuff", 321789654L, "jigglypuffsong@gmail.com", LocalDate.of(1996, 2, 27));

        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        // Buscar un contacto
        System.out.println("\nBuscando el contacto de Link:");
        Contacto contacto = agenda.buscarContacto("Link");
        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono() +
                    ", Correo Electrónico: " + contacto.getCorreoElectronico() + ", Fecha de Nacimiento: " + contacto.getFechaNacimiento());
        } else {
            System.out.println("Contacto no encontrado.");
        }

        // Eliminar un contacto
        System.out.println("\nEliminando el contacto de Peach.");
        agenda.eliminarContacto("Peach");

        // Mostrar contactos después de la eliminación
        System.out.println("Contactos en la agenda después de eliminar a Peach:");
        agenda.mostrarContactos();
    }
}
