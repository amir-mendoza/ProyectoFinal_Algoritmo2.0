
package com.mycompany.proyectofinal.algoritmo2.estructuras;

import com.mycompany.proyectofinal.algoritmo2.model.Producto;

public class VectorProductos {

    private Producto[] datos;   // Arreglo de productos
    private int size;           // Cantidad actual
    private final int MAX;      // Capacidad máxima

    // Constructor: tamaño máximo del vector
    public VectorProductos(int max) {
        this.MAX = max;
        this.datos = new Producto[max];
        this.size = 0;
    }

    // Agregar producto (retorna true si funcionó)
    // NO permite duplicados por código
    public boolean agregar(Producto p) {
        if (p == null) return false;
        if (size >= MAX) return false;
        if (buscarPorCodigo(p.getCodigo()) != null) return false; // duplicado

        datos[size++] = p;
        return true;
    }

    // Buscar producto por su código
    public Producto buscarPorCodigo(String codigo) {
        if (codigo == null) return null;

        for (int i = 0; i < size; i++) {
            if (datos[i].tieneCodigo(codigo)) {
                return datos[i];
            }
        }
        return null;
    }

    // Editar producto reemplazándolo con otro objeto Producto
    public boolean editar(String codigo, Producto nuevoProducto) {
        if (codigo == null || nuevoProducto == null) return false;

        for (int i = 0; i < size; i++) {
            if (datos[i].tieneCodigo(codigo)) {
                datos[i] = nuevoProducto;
                return true;
            }
        }
        return false;
    }

    // Borrar producto desplazando los elementos
    public boolean borrar(String codigo) {
        if (codigo == null) return false;

        for (int i = 0; i < size; i++) {
            if (datos[i].tieneCodigo(codigo)) {

                // Desplazar todos a la izquierda desde esa posición
                for (int j = i; j < size - 1; j++) {
                    datos[j] = datos[j + 1];
                }

                datos[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    // Listar productos
    public void listar() {
        if (size == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(datos[i]);
        }
    }

    // Cantidad actual de productos
    public int tamanio() {
        return size;
    }
}
