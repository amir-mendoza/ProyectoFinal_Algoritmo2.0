package com.mycompany.proyectofinal.algoritmo2.model;

// Representa un movimiento de entrada o salida de un producto
public class Movimiento {

    private String tipo;           // tipo del movimiento
    private String codigoProducto; // código del producto involucrado
    private int cantidad;          // cantidad movida

    // Constructor del movimiento
    public Movimiento(String tipo, String codigoProducto, int cantidad) {
        this.tipo = tipo;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    // Obtener tipo de movimiento
    public String getTipo() { return tipo; }

    // Obtener código del producto
    public String getCodigoProducto() { return codigoProducto; }

    // Obtener cantidad del movimiento
    public int getCantidad() { return cantidad; }

    // Mostrar información del movimiento en texto
    @Override
    public String toString() {
        return tipo + " - " + codigoProducto + " - Cantidad: " + cantidad;
    }
}
