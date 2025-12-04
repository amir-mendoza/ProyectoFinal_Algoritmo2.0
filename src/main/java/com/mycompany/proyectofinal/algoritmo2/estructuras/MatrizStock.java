package com.mycompany.proyectofinal.algoritmo2.estructuras;

public class MatrizStock {

    private int[][] matriz;         // matriz de stock por categoria y proveedor
    private int categorias;
    private int proveedores;

    // Constructor que crea la matriz y la inicia en cero
    public MatrizStock(int categorias, int proveedores) {
        this.categorias = categorias;
        this.proveedores = proveedores;
        matriz = new int[categorias][proveedores];
    }

    // Sumar cantidad al stock de una posicion
    public void sumarStock(int categoria, int proveedor, int cantidad) {
        if (validarIndices(categoria, proveedor)) {
            matriz[categoria][proveedor] += cantidad;
        }
    }

    // Restar cantidad del stock de una posicion
    public void restarStock(int categoria, int proveedor, int cantidad) {
        if (validarIndices(categoria, proveedor)) {
            matriz[categoria][proveedor] -= cantidad;

            if (matriz[categoria][proveedor] < 0) {
                matriz[categoria][proveedor] = 0; 
            }
        }
    }

    // Verificar que los indices esten dentro del rango
    private boolean validarIndices(int categoria, int proveedor) {
        return categoria >= 0 && categoria < categorias &&
               proveedor >= 0 && proveedor < proveedores;
    }

    // Mostrar todo el contenido de la matriz
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

    // Obtener la matriz completa
    public int[][] getMatriz() {
        return matriz;
    }
}
