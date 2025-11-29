package com.mycompany.proyectofinal.algoritmo2.estructuras;

import com.mycompany.proyectofinal.algoritmo2.model.Movimiento;

public class PilaMovimientos {

    private Movimiento[] pila;
    private int tope;

    public PilaMovimientos(int max) {
        pila = new Movimiento[max];
        tope = -1;
    }

    public boolean isFull() {
        return tope == pila.length - 1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean push(Movimiento mov) {
        if (isFull()) return false;
        pila[++tope] = mov;
        return true;
    }

    public Movimiento pop() {
        if (isEmpty()) return null;
        return pila[tope--];
    }

    public Movimiento peek() {
        if (isEmpty()) return null;
        return pila[tope];
    }

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
