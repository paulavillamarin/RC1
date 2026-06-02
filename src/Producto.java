public class Producto {

    protected String id;
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void registrar() {
        System.out.println("Producto registrado correctamente.");
    }

    public double calcularValor() {
        return precio * cantidad;
    }

    public double calcularValor(int cantidadVenta) {
        return precio * cantidadVenta;
    }

    public void sumarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void restarCantidad(int cantidad) {

        if (cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("Stock insuficiente.");
        }
    }

    public String getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Cantidad: " + cantidad;
    }
}