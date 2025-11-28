package com.mycompany.proyectofinal.algoritmo2.model;

public class Pedido {

    private String idPedido;
    private String codigoProducto;
    private int cantidad;

    public Pedido(String idPedido, String codigoProducto, int cantidad) {
        this.idPedido = idPedido;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getIdPedido() { return idPedido; }
    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return "Pedido " + idPedido + " | Prod: " + codigoProducto + " | Cant: " + cantidad;
    }
}
