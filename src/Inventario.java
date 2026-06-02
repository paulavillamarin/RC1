import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;
    private double presupuesto;
    private int capacidadMax;

    public Inventario(double presupuesto, int capacidadMax) {
        this.presupuesto = presupuesto;
        this.capacidadMax = capacidadMax;
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {

        if (productos.size() < capacidadMax) {
            productos.add(producto);
            System.out.println("Producto agregado.");
        } else {
            System.out.println("Inventario lleno.");
        }
    }

    public void eliminarProducto(String id) {

        Producto producto = buscarProducto(id);

        if (producto != null) {

            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");

        } else {

            System.out.println("No existe un producto con ese ID.");
        }
    }

    public Producto buscarProducto(String id) {

        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void comprarProducto(String id, int cantidad) {

        Producto p = buscarProducto(id);

        if (p != null) {
            p.sumarCantidad(cantidad);
        }
    }

    public void venderProducto(String id, int cantidad) {

        Producto producto = buscarProducto(id);

        if (producto != null) {

            if (cantidad <= producto.getCantidad()) {

                double valorPagar = producto.calcularValor(cantidad);

                producto.restarCantidad(cantidad);
                System.out.println("Venta realizada correctamente"+"Valor a pagar: $" + valorPagar);

            } else {

                System.out.println("Stock insuficiente.");
            }

        } else {

            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarProductosVencidos() {

        boolean hayVencidos = false;

        for (Producto p : productos) {

            if (p instanceof ProductoPerecedero) {

                ProductoPerecedero pp = (ProductoPerecedero) p;

                if (pp.vencido()) {
                    System.out.println(p);
                    hayVencidos = true;
                }
            }
        }

        if (!hayVencidos) {
            System.out.println("No existen productos vencidos.");
        }
    }

    public void mostrarInventario() {

        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
