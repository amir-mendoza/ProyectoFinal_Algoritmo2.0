package com.mycompany.proyectofinal.algoritmo2.controller;

import com.mycompany.proyectofinal.algoritmo2.model.Producto;
import com.mycompany.proyectofinal.algoritmo2.model.Movimiento;
import com.mycompany.proyectofinal.algoritmo2.model.Pedido;

import com.mycompany.proyectofinal.algoritmo2.estructuras.VectorProductos;
import com.mycompany.proyectofinal.algoritmo2.estructuras.MatrizStock;
import com.mycompany.proyectofinal.algoritmo2.estructuras.ListaSimple;
import com.mycompany.proyectofinal.algoritmo2.estructuras.PilaMovimientos;
import com.mycompany.proyectofinal.algoritmo2.estructuras.ColaPedidos;

public class InventarioController {

    private VectorProductos vectorProductos;
    private MatrizStock matrizStock;
    private ListaSimple listaCriticos;
    private PilaMovimientos pilaMovimientos;
    private ColaPedidos colaPedidos;

    private final int UMBRAL_CRITICO = 5; // Valor base para stock crítico

    public InventarioController(int maxProductos, int categorias, int proveedores,
                                int maxMovimientos, int maxPedidos) {

        vectorProductos = new VectorProductos(maxProductos);
        matrizStock = new MatrizStock(categorias, proveedores);
        listaCriticos = new ListaSimple();
        pilaMovimientos = new PilaMovimientos(maxMovimientos);
        colaPedidos = new ColaPedidos(maxPedidos);
    }

    /* =============================
       REGISTRAR PRODUCTO
       ============================= */
    public boolean registrarProducto(String codigo, String nombre, int categoria, int proveedor, int stock) {
        Producto p = new Producto(codigo, nombre, categoria, proveedor, stock);

        boolean agregado = vectorProductos.agregar(p);
        if (!agregado) return false;

        matrizStock.sumarStock(categoria, proveedor, stock);

        if (stock <= UMBRAL_CRITICO) {
            listaCriticos.agregarSiNoExiste(p);
        }

        return true;
    }

    /* =============================
       BUSCAR PRODUCTO
       ============================= */
    public Producto buscarProducto(String codigo) {
        return vectorProductos.buscarPorCodigo(codigo);
    }

    /* =============================
       REGISTRAR ENTRADA
       ============================= */
    public boolean registrarEntrada(String codigo, int cantidad) {

        Producto prod = vectorProductos.buscarPorCodigo(codigo);
        if (prod == null) return false;

        prod.setStock(prod.getStock() + cantidad);

        matrizStock.sumarStock(prod.getCategoria(), prod.getProveedor(), cantidad);

        pilaMovimientos.push(new Movimiento("ENTRADA", codigo, cantidad));

        if (prod.getStock() > UMBRAL_CRITICO) {
            listaCriticos.eliminar(codigo);
        }

        return true;
    }

    /* =============================
       REGISTRAR SALIDA
       ============================= */
    public boolean registrarSalida(String codigo, int cantidad) {

        Producto prod = vectorProductos.buscarPorCodigo(codigo);
        if (prod == null) return false;

        if (prod.getStock() < cantidad) return false; // No alcanza stock

        prod.setStock(prod.getStock() - cantidad);

        matrizStock.restarStock(prod.getCategoria(), prod.getProveedor(), cantidad);

        pilaMovimientos.push(new Movimiento("SALIDA", codigo, cantidad));

        if (prod.getStock() <= UMBRAL_CRITICO) {
            listaCriticos.agregarSiNoExiste(prod);
        }

        return true;
    }

    /* =============================
       LISTA DE STOCK CRÍTICO
       ============================= */
    public void mostrarStockCritico() {
        listaCriticos.mostrar();
    }

    /* =============================
       MOVIMIENTOS
       ============================= */
    public void mostrarUltimosMovimientos(int n) {
        pilaMovimientos.mostrarUltimos(n);
    }

    /* =============================
       PEDIDOS
       ============================= */
    public void registrarPedido(String idPedido, String codigo, int cantidad) {
        colaPedidos.enqueue(new Pedido(idPedido, codigo, cantidad));
    }

    public void mostrarPedidos() {
        colaPedidos.mostrar();
    }

    public void atenderPedido() {
        Pedido p = colaPedidos.dequeue();
        if (p == null) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Atendiendo pedido: " + p);
        }
    }

    /* =============================
       MIS UTILIDADES
       ============================= */
    public void mostrarStockPorCategorias() {
        matrizStock.mostrarMatriz();
    }

    public void listarProductos() {
        vectorProductos.listar();
    }
}
