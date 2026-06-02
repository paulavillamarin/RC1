import java.time.LocalDate;

public class ProductoPerecedero extends Producto {

    private LocalDate fechaCaducidad;
    private int diasRefrigeracion;
    private double temperatura;

    public ProductoPerecedero(String id, String nombre, double precio,
                              int cantidad, LocalDate fechaCaducidad,
                              int diasRefrigeracion, double temperatura) {

        super(id, nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
        this.diasRefrigeracion = diasRefrigeracion;
        this.temperatura = temperatura;
    }

    public boolean vencido() {
        return LocalDate.now().isAfter(fechaCaducidad);
    }
}