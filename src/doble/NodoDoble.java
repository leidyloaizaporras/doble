/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doble;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodoDoble<T> implements Iterable<T> {

    private Nodo<T> inicio;
    private Nodo<T> cola;
    private int tamaño;

    private static class Nodo<T> {
        T nombre;
        Nodo<T> prev;
        Nodo<T> next;

        Nodo(T nombre) {
            this.nombre = nombre;
            this.prev = null;
            this.next = null;
        }
    }

    // 1. Crear una lista vacía
    public NodoDoble() {
        inicio = null;
        cola = null;
        tamaño = 0;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    // 2. Agregar nodo al final de la lista doblemente enlazada
    public void add(T nombre) {
        Nodo<T> newNodo = new Nodo<>(nombre);
        if (isEmpty()) {
            inicio = newNodo;
            cola = newNodo;
        } else {
            cola.next = newNodo;
            newNodo.prev = cola;
            cola = newNodo;
        }
        tamaño++;
    }

    // 4. Agregar al inicio de la lista
    public void inFront(T nombre) {
        Nodo<T> newNodo = new Nodo<>(nombre);
        if (isEmpty()) {
            inicio = newNodo;
            cola = newNodo;
        } else {
            newNodo.next = inicio;
            inicio.prev = newNodo;
            inicio = newNodo;
        }
        tamaño++;
    }

    // 5. Agregar al final de la lista (redundante, ya se implementa en el método 'add')

    // 6. Agregar en una posición específica
    public void addAtIndex(T nombre, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (posicion == 0) {
            inFront(nombre);
        } else if (posicion == tamaño) {
            add(nombre);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(nombre);
            Nodo<T> actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.next;
            }
            nuevoNodo.prev = actual.prev;
            nuevoNodo.next = actual;
            actual.prev.next = nuevoNodo;
            actual.prev = nuevoNodo;
            tamaño++;
        }
    }

    // 9. Consultar un valor en la lista
    public T get(int posicion) {
        if (posicion < 0 || posicion >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < posicion; i++) {
            actual = actual.next;
        }
        return actual.nombre;
    }

    // 11. Iterador sobre la lista
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = inicio;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T datos = current.nombre;
                current = current.next;
                return datos;
            }
        };
    }

    // 10. Comparar dos listas para verificar si son iguales
    public boolean equals(NodoDoble<T> otraLista) {
        if (tamaño != otraLista.tamaño) {
            return false;
        }
        Nodo<T> actual1 = inicio;
        Nodo<T> actual2 = otraLista.inicio;
        while (actual1 != null) {
            if (!actual1.nombre.equals(actual2.nombre)) {
                return false;
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }
        return true;
    }
}
