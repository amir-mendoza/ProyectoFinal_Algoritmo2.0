package com.mycompany.proyectofinal.algoritmo2.estructuras;

public class MatrizStock {

    private int[][] matriz;         // matriz[categorias][proveedores]
    private int categorias;
    private int proveedores;

    // Constructor
    public MatrizStock(int categorias, int proveedores) {
        this.categorias = categorias;
        this.proveedores = proveedores;

        // Inicializar matriz en 0
        matriz = new int[categorias][proveedores];
    }

    // Sumar al stock de una categoría y proveedor
    public void sumarStock(int categoria, int proveedor, int cantidad) {
        if (validarIndices(categoria, proveedor)) {
            matriz[categoria][proveedor] += cantidad;
        }
    }

    // Restar al stock
    public void restarStock(int categoria, int proveedor, int cantidad) {
        if (validarIndices(categoria, proveedor)) {
            matriz[categoria][proveedor] -= cantidad;

            if (matriz[categoria][proveedor] < 0) {
                matriz[categoria][proveedor] = 0; // evitar negativos
            }
        }
    }

    // Validar índices para evitar errores
    private boolean validarIndices(int categoria, int proveedor) {
        return  categoria >= 0 && categoria < categorias &&
                proveedor >= 0 && proveedor < proveedores;
    }

    // Mostrar la matriz completa
    public void mostrarMatriz() {
        System.out.println("=== STOCK POR CATEGORIA Y PROVEEDOR ===");

        for (int i = 0; i < categorias; i++) {
            System.out.print("Categoria " + i + ": ");
            for (int j = 0; j < proveedores; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Getters (opcional)
    public int[][] getMatriz() {
        return matriz;
    }
}
