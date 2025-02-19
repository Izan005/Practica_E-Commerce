package org.example;

/**
 * @author Izan López Mora 1DAM
 * @version 1.0
 * Clase extendida de MetodoPago que contiene 2 parámetros (número de la tarjeta y tipo de la tarjeta
 * (Mastercard, Visa, Maestro)) además de un método validarTarjeta() que valida los 2 parámetros anteriores.
 */
public class TarjetaCredito extends MetodoPago {

    private String nro_tarjeta;
    private String tipo;

    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
        validarTarjeta(nro_tarjeta, tipo); //Recive los atributos con sus valores recién asignados para validarlos.
    }


    /**
     * Método que comprueba si el número de la tarjeta cumple el formato de 16 caracteres de largo.
     * @param nro_tarjeta
     * @return false si el número de la tarjeta es distinto a 16 caracteres de longitud / true si es igual a 16
     * caracteres de longitud.
     */
    public boolean comprobarNumTarjeta(String nro_tarjeta){

        if (nro_tarjeta.length() != 16){
            return false;
        }
        return true;
    }

    /**
     * Método que comprueba que el tipo de la tarjeta sea Visa, Maestro o Mastercard.
     * @param tipo
     * @return true si el tipo es uno de los permitidos (Visa, Maestro, Mastercard) / false si es distinto a un tipo
     * permitido.
     */
    public boolean comprobarTipo(String tipo){

        if (tipo.equalsIgnoreCase("VISA") || tipo.equalsIgnoreCase("MASTERCARD")
        || tipo.equalsIgnoreCase("MAESTRO")){
            return true;
        }
        return false;
    }

    /**
     * Método que recibe todos los atributos de la clase TarjetaCredito y llama a los métodos comprobarNumTarjeta
     * y comprobarTipo. Si cualquiera de los 2 métodos devuelve false, se cierra el programa ya que los datos introducidos
     * no serían correctos.
     * @param nro_tarjeta
     * @param tipo
     */
    public void validarTarjeta(String nro_tarjeta, String tipo){
        System.out.println("Validando tarjeta...");
        if (!comprobarNumTarjeta(nro_tarjeta) || !comprobarTipo(tipo)){
            System.out.println("Los datos de tu tarjeta no son correctos.");
            System.exit(0);
        }
    }

    /**
     * Método heredado de la clase MetodoPago que recibe el importe a pagar.
     * @param importe
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de importe " + importe + "€ con tarjeta de crádito " + tipo);
        System.out.println("Pago aceptado. Muchas gracias.");
    }

}
