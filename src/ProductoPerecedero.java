import java.time.LocalDate;

public class ProductoPerecedero extends Producto {

    private LocalDate fechaCaducidad;
    private int diasRefrigeracion;
    private double temperatura;

    public ProductoPerecedero(String id, String nombre, double precio, int cantidad, LocalDate fechaCaducidad, int diasRefrigeracion, double temperatura) {

        super(id, nombre, precio, cantidad);

        this.fechaCaducidad = fechaCaducidad;
        this.diasRefrigeracion = diasRefrigeracion;
        this.temperatura = temperatura;
    }

    public boolean vencido() {
        return LocalDate.now().isAfter(fechaCaducidad);
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getDiasRefrigeracion() {
        return diasRefrigeracion;
    }

    public void setDiasRefrigeracion(int diasRefrigeracion) {
        this.diasRefrigeracion = diasRefrigeracion;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {

        return super.toString() +
                " | Caduca: " + fechaCaducidad +
                " | Refrigeración: " + diasRefrigeracion + " días" +
                " | Temperatura: " + temperatura + "°C";
    }
}