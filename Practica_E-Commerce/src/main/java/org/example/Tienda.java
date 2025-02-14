package org.example;

import java.util.Scanner;

public class Tienda {

    static Scanner entrada = new Scanner(System.in);

    public static void realizarPago(MetodoPago metodo, double importe){

        metodo = iniciarPago();

    }

    public static MetodoPago iniciarPago(){

        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
        String metodo = entrada.next();

        switch (metodo.toLowerCase()){
            case "bizum":
                System.out.println("Introduce los datos de tu cuenta:");
                System.out.println("Teléfono (9 dígitos)");
                String tel = entrada.next();
                return new Bizum(tel);

            case "paypal":
                System.out.println("Introduce los datos de tu cuenta:");
                System.out.println("Cuenta (xxx.@xxx.com");
                String cuenta = entrada.next();
                System.out.println("Saldo: ");
                double saldo = entrada.nextDouble();
                return new PayPal(cuenta, saldo);

            case "tarjeta":
                System.out.println("Introduce los datos de tu cuenta:");
                System.out.println("Número (16 dígitos)");
                String num = entrada.next();
                System.out.println("Tipo (VISA, MASTERCARD, MAESTRO):");
                String tipo = entrada.next();
                return new TarjetaCredito(num, tipo);
            default:
                System.out.println("Opción no disponible.");
                iniciarPago();
                return new Bizum("x");
        }

    }

}
