package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Izan López Mora 1DAM
 * @version 1.0
 * Clase extendida de MetodoPago que cuenta con 2 atributos (un número de teléfono de 9 dígitos y el pin generado
 * automáticamente de 6 dígitos).
 */
public class Bizum extends MetodoPago{

    static Scanner entrada = new Scanner(System.in);
    static Random rdm = new Random();

    private String telefono;
    private int pin;

    public Bizum(String telefono){
        this.telefono=telefono;
        pin= pinRandom(); //Recive el pin generado automáticamente
        validarBizum(telefono, pin); //Recive los atributos con sus valores recién asignados para validarlos.

    }

    /**
     * Método que genera aleatoriamente un número de 6 cifras a ser usado como pin y lo muestea por pantalla.
     * @return pin generado automáticamente
     */
    public int pinRandom(){
        pin = rdm.nextInt(100000, 999999)+1;
        System.out.println("Pin generado: " + pin);
        return pin;
    }

    /**
     * Método que recibe el atributo telefono que comprueba que este mismo sea de 9 dígitos.
     * @param telefono
     * @return true si el telefono es de 9 dígitos / false si no lo es.
     */
    public boolean comprobarTelefono(String telefono){
        if (telefono.length() != 9){
            return false;
        }
        return true;
    }

    /**
     * Método que recibe el pin y pide al usuario que introduzca un pin para compararlos y ver si son iguales.
     * @param pin
     * @return true si el pin introducido es igual al generado anteriormente / false si no lo es
     */
    public boolean comprobarPin(int pin){
        System.out.println("Introduce el pin:");
        int pin_validar=entrada.nextInt();
        if(pin_validar==pin){
            return true;
        }
        return false;
    }

    /**
     * Método que recibe los atributos telefono y pin y llama a los métodos comprobarTelefono y comprobarPin
     * para validarlos. Si alguno de los 2 métodos da false el programa dice que los datos son incorrectos y se cierra.
     * @param telefono
     * @param pin
     */
    public void validarBizum(String telefono, int pin){

        if(!comprobarPin(pin) || !comprobarTelefono(telefono)){
            System.out.println("Validando Bizum...");
            System.out.println("Los datos de tu Bizum no son correctos.");
            System.exit(0);
        }
    }

    /**
     * Método heredado de la clase MetodoPago que recibe el importe a pagar.
     * @param importe
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de importe " + importe + "€ con Bizum.");
        System.out.println("Pago aceptado. Muchas gracias.");
    }
}
