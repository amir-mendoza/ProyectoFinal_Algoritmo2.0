package com.mycompany.proyectofinal.algoritmo2.estructuras;

import com.mycompany.proyectofinal.algoritmo2.model.Producto;

public class ListaSimple {

    // Clase interna Nodo
    private class Nodo {
        Producto producto;
        Nodo siguiente;

        Nodo(Producto producto) {
            this.producto = producto;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    // Agregar si no existe
    public void agregarSiNoExiste(Producto p) {
        if (p == null) return;

        if (esta(p.getCodigo())) return;  // Ya existe en la lista

        Nodo nuevo = new Nodo(p);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Ver si el producto ya está en la lista
    public boolean esta(String codigo) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.producto.tieneCodigo(codigo)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    // Eliminar un producto de la lista si ya no está crítico
    public void eliminar(String codigo) {
        if (cabeza == null) return;

        // Si el primero es el que se debe eliminar
        if (cabeza.producto.tieneCodigo(codigo)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.producto.tieneCodigo(codigo)) {
                anterior.siguiente = actual.siguiente;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Mostrar toda la lista
    public void mostrar() {
        System.out.println("=== PRODUCTOS EN STOCK CRÍTICO ===");

        if (cabeza == null) {
            System.out.println("No hay productos en estado crítico.");
            return;
        }

        Nodo aux = cabeza;
        while (aux != null) {
            System.out.println(aux.producto);
            aux = aux.siguiente;
        }
    }
}
