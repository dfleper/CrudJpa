package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args) {

        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        Productos producto;

        EntityManager entity = Jpa.getEntityManagerFactory().createEntityManager();

        while (opcion != 5) {

            System.out.println("1. Crear Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("Elija una opción:");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Digite el nombre del producto:");
                    producto = new Productos();
                    producto.setId(null);
                    scanner.nextLine();
                    producto.setNombre(scanner.nextLine());
                    System.out.println("Digite el precio del producto:");
                    producto.setPrecio(scanner.nextFloat());
                    System.out.println(producto);
                    entity.getTransaction().begin();
                    entity.persist(producto);
                    entity.getTransaction().commit();
                    System.out.println("Producto registrado..");
                    System.out.println("");
                    break;

                case 2:

                    System.out.println("Digite el id del producto a buscar:");
                    producto = new Productos();
                    producto = entity.find(Productos.class, scanner.nextInt());
                    if (producto != null) {
                        System.out.println(producto);
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("Producto no encontrado... Lista de productos completa");
                        List<Productos> listaProductos = new ArrayList<>();
                        Query query = entity.createQuery("SELECT p FROM Productos p");
                        listaProductos = query.getResultList();
                        for (Productos p : listaProductos) {
                            System.out.println(p);
                        }
                        System.out.println("");
                    }
                    break;

                case 3:

                    System.out.println("Digite el id del producto a actualizar:");
                    producto = new Productos();
                    producto = entity.find(Productos.class, scanner.nextInt());
                    if (producto != null) {
                        System.out.println(producto);
                        System.out.println("Digite el nombre del producto:");
                        scanner.nextLine();
                        producto.setNombre(scanner.nextLine());
                        System.out.println("Digite el precio del producto:");
                        producto.setPrecio(scanner.nextFloat());
                        entity.getTransaction().begin();
                        entity.merge(producto);
                        entity.getTransaction().commit();
                        System.out.println("Producto actualizado..");
                        System.out.println("");
                    } else {
                        System.out.println("Producto no encontrado....");
                        System.out.println("");
                    }
                    break;

                case 4:

                    System.out.println("Digite el id del producto a eliminar:");
                    producto = new Productos();
                    producto = entity.find(Productos.class, scanner.nextInt());
                    if (producto != null) {
                        System.out.println(producto);
                        entity.getTransaction().begin();
                        entity.remove(producto);
                        entity.getTransaction().commit();
                        System.out.println("Producto eliminado...");
                        System.out.println("");
                    } else {
                        System.out.println("Producto no encontrado...");
                        System.out.println("");
                    }
                    break;

                case 5:

                    entity.close();
                    Jpa.shutdown();
                    break;
                default:
                    System.out.println("Opción no válida\n");
                    System.out.println("");
                    break;
            }
        }
    }
}
