package com.mycompany.proyectofinal.algoritmo2.estructuras;

import com.mycompany.proyectofinal.algoritmo2.model.Movimiento;

public class PilaMovimientos {

    // Arreglo que almacena los movimientos
    private Movimiento[] pila;

    // Posición del último elemento agregado
    private int tope;

    // Constructor para crear la pila con un tamaño máximo
    public PilaMovimientos(int max) {
        pila = new Movimiento[max];
        tope = -1;
    }

    // Verifica si la pila está llena
    public boolean isFull() {
        return tope == pila.length - 1;
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Agrega un movimiento a la pila
    public boolean push(Movimiento mov) {
        if (isFull()) return false;
        pila[++tope] = mov;
        return true;
    }

    // Quita y devuelve el último movimiento agregado
    public Movimiento pop() {
        if (isEmpty()) return null;
        return pila[tope--];
    }

    // Devuelve el último movimiento sin quitarlo
    public Movimiento peek() {
        if (isEmpty()) return null;
        return pila[tope];
    }

    // Muestra los últimos n movimientos
    public void mostrarUltimos(int n) {
        if (isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        System.out.println("Ultimos " + n + " movimientos:");
        int count = 0;
        for (int i = tope; i >= 0 && count < n; i--) {
            System.out.println(pila[i]);
            count++;
        }
    }
}
