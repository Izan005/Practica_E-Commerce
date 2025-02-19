package org.example;


/**
 * @author Izan López Mora 1DAM
 * @version 1.0
 * Clase abstracta que hace de madre de TarjetaCreadito, PayPal y Bizum
 */
abstract class MetodoPago {


    /**
     * Método que heredan las clases hijas para calcular el importe a pagar.
     * @param importe
     */
    abstract void procesarPago(double importe);
}
