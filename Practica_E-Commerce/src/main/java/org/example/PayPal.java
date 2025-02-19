package org.example;

/**
 * @author Izan López Mora 1DAM
 * @version 1.0
 * Clase extendida de MetodoPago que cuenta con 2 atributos (la cuenta en formato xxx@xxx.com y el saldo de la cuenta)
 */
public class PayPal extends MetodoPago{
    final double SALDO_DEF = 23; //constate que define un saldo por defecto

    private String cuenta;
    private double saldo;

    /**
     * Constructor necesario cuando NO queremos el saldo por defecto.
     * @param cuenta
     */
    public PayPal(String cuenta, double saldo){
        this.cuenta=cuenta;
        this.saldo=saldo;
        validarPaypal(cuenta); //Recive los atributos con sus valores recién asignados para validarlos.
    }

    /**
     * Constructor necesario cuando queremos el saldo por defecto.
     * @param cuenta
     */
    public PayPal(String cuenta){
        this.cuenta=cuenta;
        saldo=SALDO_DEF;
        validarPaypal(cuenta); //Recive los atributos con sus valores recién asignados para validarlos.
    }

    /**
     * Método que comprueba si el formato de la cuenta es el correcto (xxx@xxx.com).
     * @param cuenta
     * @return false si el formato de la cuenta no es correcto / true si el formato es correcto.
     */
    public boolean comprobarCuenta(String cuenta){

        if(cuenta.matches(".*@*\\.com")){
            return true;
        }
        return false;
    }

    /**
     * Método que recibe el atributo cuenta y llama al método comprobarCuenta para validarla. Si el método
     * comprobarCuenta devuelve true se continua con el programa y si es false, se cierra.
     * @param cuenta
     */
    public void validarPaypal(String cuenta){
        System.out.println("Validando PayPal...");
        if (!comprobarCuenta(cuenta)){
            System.out.println("Los datos de tu PayPal no son correctos.");
            System.exit(0);
        }
    }

    /**
     * Método heredado de la clase MetodoPago que recibe el importe a pagar además de realizar una comprobación.
     * Si el saldo (atributo saldo) es mayor o igual al importe recibido por el método se procede con el pago y si no,
     * salta un error.
     * @param importe
     */
    @Override
    void procesarPago(double importe) {

        if (saldo >= importe){
            System.out.println("Procesando pago de importe " + importe + "€ con PayPal.");
            System.out.println("Pago aceptado. Muchas gracias.");
        } else {
            System.out.println("ERROR. Saldo insuficiente.");
        }
    }
}
