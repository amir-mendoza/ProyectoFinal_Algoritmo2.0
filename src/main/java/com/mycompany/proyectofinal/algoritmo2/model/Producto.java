package com.mycompany.proyectofinal.algoritmo2.model;

import com.mycompany.proyectofinal.algoritmo2.util.Catalogos;

public class Producto {
    
    // Código único del producto
    private String codigo;

    // Nombre del producto
    private String nombre;

    // Índice de categoría en la matriz de categorías
    private int categoria;

    // Índice del proveedor
    private int proveedor;

    // Cantidad actual en stock
    private int stock;

    // Constructor para inicializar un producto
    public Producto(String codigo, String nombre, int categoria, int proveedor, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.stock = stock;
    }

    // Obtener código
    public String getCodigo() {
        return codigo;
    }

    // Cambiar código
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Cambiar nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener categoría
    public int getCategoria() {
        return categoria;
    }

    // Cambiar categoría
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    // Obtener proveedor
    public int getProveedor() {
        return proveedor;
    }

    // Cambiar proveedor
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    // Obtener stock
    public int getStock() {
        return stock;
    }

    // Cambiar stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Verifica si el código coincide con otro
    public boolean tieneCodigo(String otroCodigo) {
        if (otroCodigo == null) return false;
        return this.codigo.equalsIgnoreCase(otroCodigo.trim());
    }

    // Mostrar información del producto con nombre real de categoría y proveedor
    @Override
    public String toString() {
        return String.format("[%s] %s | Categoria: %s | Proveedor: %s | Stock: %d",
                codigo,
                nombre,
                Catalogos.CATEGORIAS[categoria],
                Catalogos.PROVEEDORES[proveedor],
                stock
        );
    }
}
