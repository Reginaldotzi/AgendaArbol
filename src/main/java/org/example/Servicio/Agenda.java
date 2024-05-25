package org.example.Servicio;

import org.example.Modelo.Contacto;
import org.example.NodoContacto;

import java.time.LocalDate;

public class Agenda {
    // Nodo raíz del árbol binario de búsqueda que almacena los contactos.
    private NodoContacto raiz;

    // Constructor de la clase Agenda. Inicializa la raíz como null.
    public Agenda() {
        this.raiz = null;
    }

    // Método para agregar un nuevo contacto a la agenda.
    public void agregarContacto(String nombre, Long telefono, String correoElectronico, LocalDate fechaNacimiento) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, correoElectronico, fechaNacimiento); // Crea un nuevo objeto Contacto.
        if (this.raiz == null) {
            this.raiz = new NodoContacto(nuevoContacto); // Si el árbol está vacío, el nuevo contacto se convierte en la raíz.
        } else {
            this.insertar(this.raiz, nuevoContacto); // Si no, se inserta en su posición correcta en el árbol.
        }
    }

    // Método privado auxiliar para insertar un contacto en el árbol.
    private void insertar(NodoContacto padre, Contacto contacto) {
        if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) < 0) {
            if (padre.getIzdo() == null) {
                padre.setIzdo(new NodoContacto(contacto)); // Inserta a la izquierda si es menor y el hijo izquierdo está vacío.
            } else {
                insertar(padre.getIzdo(), contacto); // Recursivamente inserta en el subárbol izquierdo.
            }
        } else if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) > 0) {
            if (padre.getDcho() == null) {
                padre.setDcho(new NodoContacto(contacto)); // Inserta a la derecha si es mayor y el hijo derecho está vacío.
            } else {
                insertar(padre.getDcho(), contacto); // Recursivamente inserta en el subárbol derecho.
            }
        }
    }

    // Método para buscar un contacto por nombre.
    public Contacto buscarContacto(String nombre) {
        return buscar(this.raiz, nombre);
    }

    // Método privado auxiliar para buscar un contacto en el árbol.
    private Contacto buscar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null; // Si el nodo es null, el contacto no se encuentra en el árbol.
        }
        if (nombre.equals(nodo.getContacto().getNombre())) {
            return nodo.getContacto(); // Si el nombre coincide, retorna el contacto.
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            return buscar(nodo.getIzdo(), nombre); // Busca en el subárbol izquierdo si el nombre es menor.
        } else {
            return buscar(nodo.getDcho(), nombre); // Busca en el subárbol derecho si el nombre es mayor.
        }
    }

    // Método para eliminar un contacto por nombre.
    public void eliminarContacto(String nombre) {
        this.raiz = eliminar(this.raiz, nombre);
    }

    // Método privado auxiliar para eliminar un contacto del árbol.
    private NodoContacto eliminar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null; // Si el nodo es null, retorna null.
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setIzdo(eliminar(nodo.getIzdo(), nombre)); // Recursivamente elimina del subárbol izquierdo.
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            nodo.setDcho(eliminar(nodo.getDcho(), nombre)); // Recursivamente elimina del subárbol derecho.
        } else {
            if (nodo.getIzdo() == null) {
                return nodo.getDcho(); // Retorna el hijo derecho si el hijo izquierdo es null.
            } else if (nodo.getDcho() == null) {
                return nodo.getIzdo(); // Retorna el hijo izquierdo si el hijo derecho es null.
            }

            // Encuentra el nodo con el valor mínimo en el subárbol derecho.
            NodoContacto temp = minValorNodo(nodo.getDcho());
            // Reemplaza los datos del nodo actual con los del nodo mínimo.
            nodo.getContacto().setTelefono(temp.getContacto().getTelefono());
            nodo.getContacto().setNombre(temp.getContacto().getNombre());
            // Elimina el nodo mínimo del subárbol derecho.
            nodo.setDcho(eliminar(nodo.getDcho(), temp.getContacto().getNombre()));
        }
        return nodo;
    }

    // Método privado auxiliar para encontrar el nodo con el valor mínimo.
    private NodoContacto minValorNodo(NodoContacto nodo) {
        NodoContacto actual = nodo;
        while (actual.getIzdo() != null) {
            actual = actual.getIzdo(); // Encuentra el nodo más a la izquierda.
        }
        return actual;
    }

    // Método para mostrar todos los contactos en orden.
    public void mostrarContactos() {
        inOrden(this.raiz);
    }

    // Método privado auxiliar para recorrer el árbol en orden.
    private void inOrden(NodoContacto nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzdo()); // Recursivamente recorre el subárbol izquierdo.
            System.out.println("Nombre: " + nodo.getContacto().getNombre() + ", Teléfono: " + nodo.getContacto().getTelefono()+ ", Correo Electrónico: " +nodo.getContacto().getCorreoElectronico()+ ", Fecha de Nacimiento: "+nodo.getContacto().getFechaNacimiento()); // Imprime el contacto actual.
            inOrden(nodo.getDcho()); // Recursivamente recorre el subárbol derecho.
        }
    }

}
