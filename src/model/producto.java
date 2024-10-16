/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class producto extends mercancia {
    //'Producto' hereda los atributos y métodos de 'Mercancia'
    public String producto;
    private double precioProducto;
    private double porcentajeDescuento;
    private boolean esDescuentoEn2daUnidad;

    public producto(String producto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad, String codMercancia) throws Exception {
        super(codMercancia); //// Llama al constructor de la clase padre 'Mercancia' para inicializar 'codMercancia'.
        this.producto = producto;
        this.precioProducto = precioProducto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
    }

   // Implementación del método abstracto 'calcularPrecioFinal' heredado de 'Mercancia'.
    @Override
    public double calcularPrecioFinal() {
        double retorno = this.precioProducto;
        if(this.esDescuentoEn2daUnidad){
            double descuento = (this.porcentajeDescuento / 2) * this.precioProducto / 100;
            retorno = this.precioProducto - descuento; //Aplica el descuento y ajusta el precio final.
        }
        return retorno; //Retorna el precio final calculado.
    
    }
    
    /// Método getter para 'esDescuentoEn2daUnidad'.
    public boolean isEsDescuentoEn2daUnidad() {
        return esDescuentoEn2daUnidad;
    }
    
}
