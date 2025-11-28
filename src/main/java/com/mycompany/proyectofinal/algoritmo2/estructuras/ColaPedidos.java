package com.mycompany.proyectofinal.algoritmo2.estructuras;

import com.mycompany.proyectofinal.algoritmo2.model.Pedido;

public class ColaPedidos {

    private Pedido[] cola;
    private int frente;
    private int fin;
    private int size;
    private final int MAX;

    public ColaPedidos(int max) {
        this.MAX = max;
        this.cola = new Pedido[max];
        this.frente = 0;
        this.fin = -1;
        this.size = 0;
    }

    // Insertar un pedido (enqueue)
    public boolean enqueue(Pedido p) {
        if (size >= MAX) return false; // cola llena

        fin = (fin + 1) % MAX; // avance circular
        cola[fin] = p;
        size++;
        return true;
    }

    // Atender pedido (dequeue)
    public Pedido dequeue() {
        if (size == 0) return null; // cola vacía

        Pedido p = cola[frente];
        frente = (frente + 1) % MAX;
        size--;
        return p;
    }

    // Mostrar todos los pedidos pendientes
    public void mostrar() {
        System.out.println("=== PEDIDOS PENDIENTES ===");

        if (size == 0) {
            System.out.println("No hay pedidos en cola.");
            return;
        }

        int index = frente;
        for (int i = 0; i < size; i++) {
            System.out.println(cola[index]);
            index = (index + 1) % MAX;
        }
    }

    // Saber si está vacía
    public boolean estaVacia() {
        return size == 0;
    }
}
