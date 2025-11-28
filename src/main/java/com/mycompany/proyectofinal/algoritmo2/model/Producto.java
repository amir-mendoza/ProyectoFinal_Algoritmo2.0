package com.mycompany.proyectofinal.algoritmo2.model;

import com.mycompany.proyectofinal.algoritmo2.util.Catalogos;

public class Producto {
    
    private String codigo;
    private String nombre;
    private int categoria;
    private int proveedor;
    private int stock;

    public Producto(String codigo, String nombre, int categoria, int proveedor, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.stock = stock;
    }

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

    public boolean tieneCodigo(String otroCodigo) {
        if (otroCodigo == null) return false;
        return this.codigo.equalsIgnoreCase(otroCodigo.trim());
    }

    // 🎯 MOSTRAR PRODUCTO BONITO (NOMBRE REAL DE CATEGORÍA Y PROVEEDOR)
    @Override
    public String toString() {
        return String.format("[%s] %s | Categoría: %s | Proveedor: %s | Stock: %d",
                codigo,
                nombre,
                Catalogos.CATEGORIAS[categoria],
                Catalogos.PROVEEDORES[proveedor],
                stock
        );
    }
}
