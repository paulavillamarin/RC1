public class Producto {

    private String id;
    private String nombre;
    private double precio;
    private int cantidad;

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

    // GETTERS

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Cantidad: " + cantidad;
    }
}