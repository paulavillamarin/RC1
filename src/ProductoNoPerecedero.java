public class ProductoNoPerecedero extends Producto {

    private int vidaUtil;
    private String categoria;

    public ProductoNoPerecedero(String id, String nombre, double precio,
                                int cantidad, int vidaUtil, String categoria) {

        super(id, nombre, precio, cantidad);
        this.vidaUtil = vidaUtil;
        this.categoria = categoria;
    }

    public String tipoAlmacenamiento() {

        if (categoria.equalsIgnoreCase("Electrónico")) {
            return "Lugar seco y ventilado";
        }

        if (categoria.equalsIgnoreCase("Limpieza")) {
            return "Lejos de alimentos";
        }

        return "Almacenamiento general";
    }
}