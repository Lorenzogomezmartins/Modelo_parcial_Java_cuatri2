/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import model.mercancia; // Importa la clase Mercancia
import model.producto; // Importa la clase Producto
import model.servicio; // Importa la clase Servicio
import model.sistema; // Importa la clase Sistema
import java.util.List; // Importa la clase List
/**
 *
 * @author Usuario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         sistema sistema = new sistema(); // Crea una instancia de 'sistema'.

        try {
            // 1-1: Intentar crear el objeto servicio.
            System.out.println("1-1:");
            try {
                servicio servicio1 = new servicio("Mantenimiento máquina de cortar pasto", 2500.0, 15.0, true, "897323");
            } catch (Exception e) {
                System.out.println("Error al crear servicio: " + e.getMessage());
            }

            // 1-2: Crear e imprimir el objeto servicio.
            System.out.println("1-2:");
            servicio servicio2 = new servicio("Mantenimiento máquina de cortar pasto", 2500.0, 15.0, true, "8973231");
            System.out.println("Servicio creado: " + servicio2.getCodMercancia() + ", " + servicio2.servicio);

            // 1-3: Intentar crear el objeto producto.
            System.out.println("1-3:");
            try {
                producto producto1 = new producto("Manguera de desagote lavarropa", 650.0, 15.0, true, "432597");
            } catch (Exception e) {
                System.out.println("Error al crear producto: " + e.getMessage());
            }

            // 1-4: Crear e imprimir el objeto producto.
            System.out.println("1-4:");
            producto producto2 = new producto("Manguera de desagote lavarropa", 650.0, 15.0, true, "4325971");
            System.out.println("Producto creado: " + producto2.getCodMercancia() + ", " + producto2.producto);

            // 2-1: Calcular e imprimir el precio final del servicio.
            System.out.println("2-1:");
            double precioFinalServicio = servicio2.calcularPrecioFinal();
            System.out.println("Precio final del servicio: " + precioFinalServicio);

            // 2-2: Calcular e imprimir el precio final del producto.
            System.out.println("2-2:");
            double precioFinalProducto = producto2.calcularPrecioFinal();
            System.out.println("Precio final del producto: " + precioFinalProducto);

            // 3-1: Agregar los siguientes objetos al sistema.
            System.out.println("3-1:");
            sistema.agregarProducto("3892871", "Aceite para máquinas", 430.0, 10.0, true);
            sistema.agregarServicio("3892815", "Mantenimiento de cortadora de césped", 2520.0, 0.0, true);
            sistema.agregarProducto("9381925", "Tambor lavarropa", 7500.0, 25.0, false);
            sistema.agregarServicio("3481759", "Mantenimiento estufa", 1250.0, 0.0, false);
            System.out.println("Objetos agregados al sistema.");

            // 3-2: Reintentar agregar el servicio existente.
            System.out.println("3-2:");
            try {
               sistema.agregarServicio("3892815", "Mantenimiento de cortadora de césped", 2520.0, 0.0, true);
            } catch (Exception e) {
                System.out.println("Error al agregar servicio: " + e.getMessage());
            }

            // 3-3: Reintentar agregar el producto existente.
            System.out.println("3-3:");
            try {
                sistema.agregarProducto("9381925", "Tambor lavarropa", 7500.0, 25.0, false);
            } catch (Exception e) {
                System.out.println("Error al agregar producto: " + e.getMessage());
            }

            // 4: Traer todos los objetos mercancia que están en oferta (enOferta=true).
            System.out.println("4:");
            List<mercancia> mercanciasEnOferta = sistema.traerMercancia(true);
            for (mercancia m : mercanciasEnOferta) {
                System.out.println("Mercancía en oferta: " + m.getCodMercancia());
            }
        } catch (Exception e) {
            System.out.println("Error en el sistema: " + e.getMessage());
        }
    }
    
}
