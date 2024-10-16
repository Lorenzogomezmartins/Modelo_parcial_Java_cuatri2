/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class sistema {

    private List<mercancia> lstMercancia;

    public sistema() {
        this.lstMercancia = new ArrayList<>();
    }
    
    //// Método para obtener una mercancía a partir de su código.
    public mercancia traerMercancia(String codMercancia) {
        mercancia retorno = null; // // Inicializa la variable 'retorno' como nula.
        for (mercancia m : lstMercancia) {
            if (m.getCodMercancia().equals(codMercancia)) {
                retorno = m; //// Si coincide, asigna la mercancía encontrada a 'retorno
            }
        }
        return retorno; //// Retorna la mercancía encontrada o null si no se encontró.
    }
    
    //// Método para obtener una lista de mercancías en oferta.
    public List<mercancia> traerMercancia(boolean enOferta) throws NotFoundException {
        List<mercancia> mercanciasEnOferta = new ArrayList<>(); // Crea una lista para almacenar mercancías en oferta.

        for (mercancia m : lstMercancia) {
             // Verifica si la mercancía es un producto y está en oferta.
            if (m instanceof producto && enOferta == true) {
                 // Verifica si el producto tiene descuento en la segunda unidad
                if (((producto) m).isEsDescuentoEn2daUnidad()) {
                    mercanciasEnOferta.add(m); // Agrega el producto a la lista de ofertas.
                }
                //verifica si esta en promocion y si es u  producto y esta en oferta
            } else if (m instanceof servicio && enOferta == true) {
                if (((servicio) m).isEnPromocion()) {
                    mercanciasEnOferta.add(m);
                }

            }

        }
         // Si no se encontraron mercancías en oferta, lanza una excepción.
        if (mercanciasEnOferta.isEmpty()) {
            throw new NotFoundException("No se encontraron mercancías en oferta");
        }
        return mercanciasEnOferta; // Retorna la lista de mercancías en oferta.
    }

    // Método para agregar un nuevo producto a la lista de mercancías.
    public boolean agregarProducto(String codMercancia, String producto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad) throws Exception {
        boolean retorno = false;
        if (traerMercancia(codMercancia) == null) {
            producto productoNuevo = new producto(producto, precioProducto, porcentajeDescuento, esDescuentoEn2daUnidad, codMercancia);
            retorno = true;
            lstMercancia.add(productoNuevo);
        } else {
            throw new Exception("El producto ya existe");

        }
        return retorno;
    }

    public boolean agregarServicio(String codMercancia, String servicio, double presupuesto, double porcentajeDescuento, boolean enPromocion) throws Exception {
        boolean retorno = false;
         // Verifica si ya existe una mercancía con el mismo código.
        if (traerMercancia(codMercancia) == null) {
            // Crea un nuevo objeto Producto.
            servicio servicioNuevo = new servicio(servicio, presupuesto, porcentajeDescuento, enPromocion, codMercancia);
            retorno = true;
            lstMercancia.add(servicioNuevo);
        } else {
            throw new Exception("El servicio ya existe");

        }
        return retorno; //retorna el resultado de la operación (true o false).
    }

}
