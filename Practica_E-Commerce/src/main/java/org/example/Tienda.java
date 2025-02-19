package org.example;

import java.util.Scanner;

/**
 * @author Izan López Mora 1DAM
 * @version 1.0
 * Clase que se encarga de crear los objetos de tipo MetodoPago pertinentes la cual nos deja elegir si queremos que
 * el objeto a crear sea de las clases hijas Bizum, TarjetaCredito o PayPal.
 */
public class Tienda {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Método que contiene un switch-case que recibe el tipo de objeto hijo a crear (Bizum, PayPal, TarjetaCredito)
     * encargado de llamar al método de creación de estos objetos (crearBizum/Paypal/Tarjeta) para usar sus resultados
     * en el método realizarPago.
     */
    public static void iniciarPago(){

        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
        String metodo = entrada.next();

        switch (metodo.toLowerCase()){
            case "bizum":

                realizarPago(crearBizum(), 0);
                break;

            case "paypal":

                realizarPago(crearPaypal(), 0);
                break;

            case "tarjeta":

                realizarPago(crearTarjeta(), 0);
                break;
            default:
                System.out.println("Opción no disponible.");
                iniciarPago();
        }

    }

    /**
     * Método que crea un objeto de la clase abstracta MetodoPago con los atributos de la clase hija Bizum preguntando
     * al usuario el número de teléfono.
     * @return objeto de la clase abstracta MetodoPago con los atributos de la clase hija Bizum.
     */
    public static MetodoPago crearBizum(){
        System.out.println("Introduce los datos de tu cuenta:");
        System.out.println("Teléfono (9 dígitos)");
        String tel = entrada.next();
        MetodoPago metodobizum = new Bizum(tel);
        return metodobizum;
    }

    /**
     * Método que crea un objeto de la clase abstracta MetodoPago con los atributos de la clase hija PayPal preguntando
     * al usuario la cuenta y si quiere introducir saldo o no. Si el usuario dice que no quiere introducir un saldo, se
     * le asignará un saldo por defecto (23€) gracias a la constante de la clase PayPal.
     * @return objeto de la clase abstracta MetodoPago con los atributos de la clase hija PayPal.
     */
    public static MetodoPago crearPaypal(){
        MetodoPago metodopaypal;
        System.out.println("Introduce los datos de tu cuenta:");
        System.out.println("Formato: (xxx.@xxx.com)");
        String cuenta = entrada.next();
        System.out.println("Introducir saldo [S] / [N/cualquier_letra]");
        String opc = entrada.next();

        switch (opc.toLowerCase()){
            case"s":
                System.out.println("Saldo: ");
                double saldo = entrada.nextDouble();
                metodopaypal = new PayPal(cuenta, saldo);
                break;
            default:
                metodopaypal = new PayPal(cuenta);
                break;
        }
        return metodopaypal;
    }

    /**
     * Método que crea un objeto de la clase abstracta MetodoPago con los atributos de la clase hija TarjetaCredito
     * preguntando al usuario el número de la cuenta y el tipo de tarjeta.
     * @return objeto de la clase abstracta MetodoPago con los atributos de la clase hija TarjetaCredito.
     */
    public static MetodoPago crearTarjeta(){
        System.out.println("Introduce los datos de tu cuenta:");
        System.out.println("Número (16 dígitos)");
        String num = entrada.next();
        System.out.println("Tipo (VISA, MASTERCARD, MAESTRO):");
        String tipo = entrada.next();
        MetodoPago metodotarjeta = new TarjetaCredito(num, tipo);
        return metodotarjeta;
    }

    /**
     * Método que recibe un objeto de tipo MetodoPago (el que hemos creado gracias a los métodos anteriores) y un importe
     * a pagar al que le daremos un valor en este método. Seguidamente accederemos con el objeto de tipo MetodoPago y el
     * importe al método procesoPago (es abstracto por lo que existe en todos las clases hijas de MetodoPago).
     * @param metodo
     * @param importe
     */
    public static void realizarPago(MetodoPago metodo, double importe){

        System.out.println("Introduce importe a pagar:");
        importe=entrada.nextDouble();
        metodo.procesarPago(importe);
    }
}
