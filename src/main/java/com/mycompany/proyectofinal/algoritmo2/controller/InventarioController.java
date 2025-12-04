// Controlador que maneja productos, stock, movimientos y pedidos
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

    private final int UMBRAL_CRITICO = 5;

    public InventarioController(int maxProductos, int categorias, int proveedores,
                                int maxMovimientos, int maxPedidos) {

        vectorProductos = new VectorProductos(maxProductos);
        matrizStock = new MatrizStock(categorias, proveedores);
        listaCriticos = new ListaSimple();
        pilaMovimientos = new PilaMovimientos(maxMovimientos);
        colaPedidos = new ColaPedidos(maxPedidos);
    }

    // Registrar un producto nuevo
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

    // Buscar producto por código
    public Producto buscarProducto(String codigo) {
        return vectorProductos.buscarPorCodigo(codigo);
    }

    // Registrar entrada al stock
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

    // Registrar salida del stock
    public boolean registrarSalida(String codigo, int cantidad) {

        Producto prod = vectorProductos.buscarPorCodigo(codigo);
        if (prod == null) return false;

        if (prod.getStock() < cantidad) return false;

        prod.setStock(prod.getStock() - cantidad);

        matrizStock.restarStock(prod.getCategoria(), prod.getProveedor(), cantidad);

        pilaMovimientos.push(new Movimiento("SALIDA", codigo, cantidad));

        if (prod.getStock() <= UMBRAL_CRITICO) {
            listaCriticos.agregarSiNoExiste(prod);
        }

        return true;
    }

    // Mostrar productos en stock crítico
    public void mostrarStockCritico() {
        listaCriticos.mostrar();
    }

    // Mostrar últimos movimientos del inventario
    public void mostrarUltimosMovimientos(int n) {
        pilaMovimientos.mostrarUltimos(n);
    }

    // Registrar un pedido
    public void registrarPedido(String idPedido, String codigo, int cantidad) {
        colaPedidos.enqueue(new Pedido(idPedido, codigo, cantidad));
    }

    // Mostrar pedidos pendientes
    public void mostrarPedidos() {
        colaPedidos.mostrar();
    }

    // Atender un pedido y registrar salida
    public void atenderPedido() {
        if (colaPedidos.estaVacia()) {
            System.out.println("No hay pedidos pendientes.");
            return;
        }

        Pedido pedido = colaPedidos.dequeue();
        String codigo = pedido.getCodigoProducto();
        int cantidad = pedido.getCantidad();

        registrarSalida(codigo, cantidad);

        System.out.println("Pedido atendido: " + codigo + " | Cantidad despachada: " + cantidad);
    }

    // Mostrar stock por categorías y proveedores
    public void mostrarStockPorCategorias() {
        matrizStock.mostrarMatriz();
    }

    // Listar todos los productos registrados
    public void listarProductos() {
        vectorProductos.listar();
    }
}
