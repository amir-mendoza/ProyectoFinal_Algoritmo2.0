package com.mycompany.proyectofinal.algoritmo2.main;

import com.mycompany.proyectofinal.algoritmo2.controller.InventarioController;
import com.mycompany.proyectofinal.algoritmo2.model.Producto;
import com.mycompany.proyectofinal.algoritmo2.util.Catalogos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CONFIGURACIÓN DEL SISTEMA
        InventarioController controller = new InventarioController(
                200,   // máximo productos
                5,     // categorías
                5,     // proveedores
                200,   // pila movimientos
                100    // cola pedidos
        );

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== MENU DEL SUBSISTEMA DE INVENTARIO =========");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Registrar entrada de stock");
            System.out.println("4. Registrar salida de stock");
            System.out.println("5. Mostrar stock critico");
            System.out.println("6. Registrar pedido");
            System.out.println("7. Ver pedidos pendientes");
            System.out.println("8. Mostrar stock por categoria y proveedor");
            System.out.println("9. Ver ultimos movimientos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {

                case 1 -> {
                    System.out.println("--- Registrar producto ---");

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Categoria (0 a 4): ");
                    Catalogos.mostrarCategorias();
                    int categoria = Integer.parseInt(sc.nextLine());

                    System.out.print("Proveedor (0 a 4): ");
                    Catalogos.mostrarProveedores();
                    int proveedor = Integer.parseInt(sc.nextLine());

                    if (categoria < 0 || categoria >= Catalogos.CATEGORIAS.length) {
                        System.out.println("Categoria invalida. Debe estar entre 0 y " + (Catalogos.CATEGORIAS.length - 1));
                        break;
                    }

                    if (proveedor < 0 || proveedor >= Catalogos.PROVEEDORES.length) {
                        System.out.println("Proveedor invalido. Debe estar entre 0 y " + (Catalogos.PROVEEDORES.length - 1));
                        break;
                    }

                    System.out.print("Stock inicial: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    boolean ok = controller.registrarProducto(codigo, nombre, categoria, proveedor, stock);

                    if (ok) {
                        System.out.println("Producto registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar (codigo duplicado o sistema lleno).");
                    }
                }

                case 2 -> {
                    System.out.println("--- Buscar producto ---");
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    Producto p = controller.buscarProducto(codigo);

                    if (p == null) {
                        System.out.println("Producto no encontrado.");
                    } else {
                        System.out.println("Encontrado: " + p);
                    }
                }

                case 3 -> {
                    System.out.println("--- Registrar entrada ---");
                    System.out.print("Codigo del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Cantidad a ingresar: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    boolean ok = controller.registrarEntrada(codigo, cantidad);

                    if (ok) System.out.println("Entrada registrada.");
                    else System.out.println("No se pudo registrar (producto no existe).");
                }

                case 4 -> {
                    System.out.println("--- Registrar salida ---");
                    System.out.print("Codigo del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Cantidad a retirar: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    boolean ok = controller.registrarSalida(codigo, cantidad);

                    if (ok) System.out.println("Salida registrada.");
                    else System.out.println("No se pudo registrar (producto no existe o stock insuficiente).");
                }

                case 5 -> {
                    System.out.println("--- STOCK CRITICO ---");
                    controller.mostrarStockCritico();
                }

                case 6 -> {
                    System.out.println("--- Registrar pedido ---");

                    System.out.print("ID Pedido: ");
                    String id = sc.nextLine();

                    System.out.print("Codigo del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Cantidad pedida: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    controller.registrarPedido(id, codigo, cantidad);
                    System.out.println("Pedido registrado.");
                }

                case 7 -> {
                    System.out.println("--- Pedidos pendientes ---");
                    controller.mostrarPedidos();

                    System.out.print("Atender siguiente pedido? (s/n): ");
                    String r = sc.nextLine();

                    if (r.equalsIgnoreCase("s")) {
                        controller.atenderPedido();
                    }
                }

                case 8 -> {
                    System.out.println("--- STOCK POR CATEGORIA Y PROVEEDOR ---");
                    controller.mostrarStockPorCategorias();
                }

                case 9 -> {
                    System.out.println("--- Ultimos movimientos ---");

                    System.out.print("Cuantos movimientos ver?: ");
                    int n = Integer.parseInt(sc.nextLine());

                    controller.mostrarUltimosMovimientos(n);
                }

                case 0 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opcion invalida.");
            }
        }

        sc.close();
    }
}
