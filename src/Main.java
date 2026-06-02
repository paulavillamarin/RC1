import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventario inventario = new Inventario(10000, 100);

        int opcion;

        do {

            System.out.println("\nMENU");
            System.out.println("1. Registrar producto perecedero");
            System.out.println("2. Registrar producto no perecedero");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Vender producto");
            System.out.println("5. Comprar producto");
            System.out.println("6. Mostrar productos vencidos");
            System.out.println("7. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    String id;

                    do {
                        System.out.print("ID: ");
                        id = sc.nextLine().trim();

                        if (id.isEmpty()) {
                            System.out.println("El ID no puede estar vacío.");
                        } else if (inventario.buscarProducto(id) != null) {
                            System.out.println("Ya existe un producto con ese ID.");
                            id = "";
                        }

                    } while (id.isEmpty());

                    String nombre;

                    do {
                        System.out.print("Nombre: ");
                        nombre = sc.nextLine().trim();

                        if (nombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío.");
                        }

                    } while (nombre.isEmpty());

                    double precio;

                    do {
                        System.out.print("Precio: ");
                        precio = sc.nextDouble();

                        if (precio <= 0) {
                            System.out.println("El precio debe ser mayor que 0.");
                        }

                    } while (precio <= 0);

                    int cantidad;

                    do {
                        System.out.print("Cantidad: ");
                        cantidad = sc.nextInt();

                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor que 0.");
                        }

                    } while (cantidad <= 0);

                    int anio;
                    int mes;
                    int dia;

                    System.out.print("Año de caducidad: ");
                    anio = sc.nextInt();

                    System.out.print("Mes de caducidad: ");
                    mes = sc.nextInt();

                    System.out.print("Día de caducidad: ");
                    dia = sc.nextInt();

                    int diasRef;

                    do {
                        System.out.print("Días de refrigeración: ");
                        diasRef = sc.nextInt();

                        if (diasRef <= 0) {
                            System.out.println("Debe ser mayor que 0.");
                        }

                    } while (diasRef <= 0);

                    double temperatura;

                    do {
                        System.out.print("Temperatura: ");
                        temperatura = sc.nextDouble();

                    } while (temperatura < -50 || temperatura > 50);

                    ProductoPerecedero perecedero =
                            new ProductoPerecedero(
                                    id,
                                    nombre,
                                    precio,
                                    cantidad,
                                    LocalDate.of(anio, mes, dia),
                                    diasRef,
                                    temperatura
                            );

                    inventario.agregarProducto(perecedero);

                    break;

                case 2:

                    String id2;

                    do {
                        System.out.print("ID: ");
                        id2 = sc.nextLine().trim();

                        if (id2.isEmpty()) {
                            System.out.println("El ID no puede estar vacío.");
                        } else if (inventario.buscarProducto(id2) != null) {
                            System.out.println("Ya existe un producto con ese ID.");
                            id2 = "";
                        }

                    } while (id2.isEmpty());

                    String nombre2;

                    do {
                        System.out.print("Nombre: ");
                        nombre2 = sc.nextLine().trim();

                        if (nombre2.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío.");
                        }

                    } while (nombre2.isEmpty());

                    double precio2;

                    do {
                        System.out.print("Precio: ");
                        precio2 = sc.nextDouble();

                        if (precio2 <= 0) {
                            System.out.println("El precio debe ser mayor que 0.");
                        }

                    } while (precio2 <= 0);

                    int cantidad2;

                    do {
                        System.out.print("Cantidad: ");
                        cantidad2 = sc.nextInt();

                        if (cantidad2 <= 0) {
                            System.out.println("La cantidad debe ser mayor que 0.");
                        }

                    } while (cantidad2 <= 0);

                    int vidaUtil;

                    do {
                        System.out.print("Vida útil (días): ");
                        vidaUtil = sc.nextInt();

                        if (vidaUtil <= 0) {
                            System.out.println("Debe ser mayor que 0.");
                        }

                    } while (vidaUtil <= 0);

                    sc.nextLine();

                    String categoria;

                    do {
                        System.out.print("Categoría(Electrónico/Limpieza/Otro): ");
                        categoria = sc.nextLine().trim();

                        if (categoria.isEmpty()) {
                            System.out.println("La categoría no puede estar vacía.");
                        }

                    } while (categoria.isEmpty());

                    ProductoNoPerecedero noPerecedero =
                            new ProductoNoPerecedero(
                                    id2,
                                    nombre2,
                                    precio2,
                                    cantidad2,
                                    vidaUtil,
                                    categoria
                            );

                    inventario.agregarProducto(noPerecedero);
                    System.out.println("Tipo de almacenamiento: " + noPerecedero.tipoAlmacenamiento());

                    break;

                case 3:

                    inventario.mostrarInventario();

                    break;

                case 4:

                    System.out.print("ID del producto: ");
                    String idVenta = sc.nextLine();

                    Producto productoVenta = inventario.buscarProducto(idVenta);

                    if (productoVenta == null) {

                        System.out.println("Producto no encontrado.");

                    } else {

                        int cantVenta;

                        do {

                            System.out.print("Cantidad a vender: ");
                            cantVenta = sc.nextInt();

                            if (cantVenta <= 0) {
                                System.out.println("La cantidad debe ser mayor que 0.");
                            }

                        } while (cantVenta <= 0);

                        inventario.venderProducto(idVenta, cantVenta);
                    }

                    break;


                case 5:

                    System.out.print("ID del producto: ");
                    String idCompra = sc.nextLine();

                    Producto productoCompra = inventario.buscarProducto(idCompra);

                    if (productoCompra == null) {

                        System.out.println("Producto no encontrado.");

                    } else {

                        int cantCompra;

                        do {

                            System.out.print("Cantidad a comprar: ");
                            cantCompra = sc.nextInt();

                            if (cantCompra <= 0) {
                                System.out.println("La cantidad debe ser mayor que 0.");
                            }

                        } while (cantCompra <= 0);

                        inventario.comprarProducto(idCompra, cantCompra);
                    }

                    break;

                case 6:

                    inventario.mostrarProductosVencidos();

                    break;

                case 7:

                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    String idEliminar = sc.nextLine();

                    inventario.eliminarProducto(idEliminar);

                    break;

                case 0:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
 