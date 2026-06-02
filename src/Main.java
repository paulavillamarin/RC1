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

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Año de caducidad: ");
                    int anio = sc.nextInt();

                    System.out.print("Mes de caducidad: ");
                    int mes = sc.nextInt();

                    System.out.print("Dia de caducidad: ");
                    int dia = sc.nextInt();

                    System.out.print("Dias de refrigeracion: ");
                    int diasRef = sc.nextInt();

                    System.out.print("Temperatura: ");
                    double temperatura = sc.nextDouble();

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

                    System.out.print("ID: ");
                    String id2 = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre2 = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio2 = sc.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad2 = sc.nextInt();

                    System.out.print("Vida util (dias): ");
                    int vidaUtil = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

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

                    break;

                case 3:

                    inventario.mostrarInventario();

                    break;

                case 4:

                    System.out.print("ID del producto: ");
                    String idVenta = sc.nextLine();

                    System.out.print("Cantidad a vender: ");
                    int cantVenta = sc.nextInt();

                    inventario.venderProducto(idVenta, cantVenta);

                    break;

                case 5:

                    System.out.print("ID del producto: ");
                    String idCompra = sc.nextLine();

                    System.out.print("Cantidad a comprar: ");
                    int cantCompra = sc.nextInt();

                    inventario.comprarProducto(idCompra, cantCompra);

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
 