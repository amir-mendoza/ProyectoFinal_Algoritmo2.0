package com.mycompany.proyectofinal.algoritmo2.util;

public class Catalogos {

    public static final String[] CATEGORIAS = {
        "Abarrotes",
        "Bebidas",
        "Limpieza",
        "Enlatados",
        "Snacks"
    };

    public static final String[] PROVEEDORES = {
        "Alicorp",
        "Gloria",
        "San Fernando",
        "Nestle",
        "PepsiCo"
    };

    public static void mostrarCategorias() {
        System.out.println("Categorias:");
        for (int i = 0; i < CATEGORIAS.length; i++) {
            System.out.println(i + " - " + CATEGORIAS[i]);
        }
    }

    public static void mostrarProveedores() {
        System.out.println("Proveedores:");
        for (int i = 0; i < PROVEEDORES.length; i++) {
            System.out.println(i + " - " + PROVEEDORES[i]);
        }
    }
}
