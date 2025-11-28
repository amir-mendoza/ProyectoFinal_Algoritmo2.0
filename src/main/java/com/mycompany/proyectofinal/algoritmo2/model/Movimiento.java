package com.mycompany.proyectofinal.algoritmo2.model;

public class Movimiento {

    private String tipo;           // "ENTRADA" o "SALIDA"
    private String codigoProducto; // código del producto
    private int cantidad;

    public Movimiento(String tipo, String codigoProducto, int cantidad) {
        this.tipo = tipo;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getTipo() { return tipo; }
    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return tipo + " - " + codigoProducto + " - Cantidad: " + cantidad;
    }
}
