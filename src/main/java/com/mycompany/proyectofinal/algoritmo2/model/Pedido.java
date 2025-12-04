package com.mycompany.proyectofinal.algoritmo2.model;

// Clase que representa un pedido realizado
public class Pedido {

    private String idPedido;        // Identificador del pedido
    private String codigoProducto;  // Código del producto solicitado
    private int cantidad;           // Cantidad solicitada en el pedido

    // Constructor para crear un pedido
    public Pedido(String idPedido, String codigoProducto, int cantidad) {
        this.idPedido = idPedido;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    // Devuelve el id del pedido
    public String getIdPedido() { 
        return idPedido; 
    }

    // Devuelve el código del producto del pedido
    public String getCodigoProducto() { 
        return codigoProducto; 
    }

    // Devuelve la cantidad solicitada
    public int getCantidad() { 
        return cantidad; 
    }

    // Muestra la información del pedido en texto
    @Override
    public String toString() {
        return "Pedido " + idPedido + " | Prod: " + codigoProducto + " | Cant: " + cantidad;
    }
}
