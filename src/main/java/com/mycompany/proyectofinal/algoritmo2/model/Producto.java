package com.mycompany.proyectofinal.algoritmo2.model;

public class Producto {
    
    // Atributos del producto
    private String codigo;
    private String nombre;
    private int categoria;    // índice de categoría (ej: 0,1,2...)
    private int proveedor;    // índice de proveedor (ej: 0,1,2...)
    private int stock;

    // Constructor
    public Producto(String codigo, String nombre, int categoria, int proveedor, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.stock = stock;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para comparar códigos (evita duplicados)
    public boolean tieneCodigo(String otroCodigo) {
        if (otroCodigo == null) return false;
        return this.codigo.equalsIgnoreCase(otroCodigo.trim());
    }

    // Mostrar producto bonito
    @Override
    public String toString() {
        return String.format("[%s] %s | Cat:%d | Prov:%d | Stock:%d",
                codigo, nombre, categoria, proveedor, stock);
    }
}
