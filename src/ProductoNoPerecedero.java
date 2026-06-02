public class ProductoNoPerecedero extends Producto {

    private int vidaUtil;
    private String categoria;

    public ProductoNoPerecedero(String id, String nombre, double precio, int cantidad, int vidaUtil, String categoria) {

        super(id, nombre, precio, cantidad);

        this.vidaUtil = vidaUtil;
        this.categoria = categoria;
    }

    public String tipoAlmacenamiento() {

        if (categoria.equalsIgnoreCase("Limpieza")) {
            return "Separado de alimentos";
        }

        if (categoria.equalsIgnoreCase("Electronico")) {
            return "Lugar seco";
        }

        return "Almacenamiento general";
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {

        return super.toString() +
                " | Vida útil: " + vidaUtil + " días" +
                " | Categoría: " + categoria +
                " | Almacenamiento: " + tipoAlmacenamiento();
    }
}