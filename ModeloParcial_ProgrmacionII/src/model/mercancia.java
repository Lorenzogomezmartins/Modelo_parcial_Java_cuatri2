/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public abstract class mercancia {

    public String getCodMercancia() {
        return codMercancia;
    }

     //Se usa 'protected' para permitir que las subclases accedan a él directamente
    protected String codMercancia;
    
    //Constructor de la clase 'Mercancia'. Recibe un parámetro 'codMercancia' que se espera sea un código de 7 caracteres.
    public mercancia(String codMercancia) throws Exception {
         this.codMercancia = codMercancia;
        if (this.codMercancia.length() != 7){
            throw new Exception("No tiene justo 7 caracteres");
        }
        //Asigna el valor pasado por el constructor al atributo 'codMercancia'.
        this.codMercancia = codMercancia;
    }

    // Método abstracto que obliga a las subclases a implementar la lógica.
    public abstract double calcularPrecioFinal();

}
