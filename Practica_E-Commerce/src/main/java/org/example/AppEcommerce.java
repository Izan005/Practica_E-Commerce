package org.example;

public class AppEcommerce {
    public static void main(String[] args) {

        // Pruebas TarjetaCredito
//        TarjetaCredito tc1 = new TarjetaCredito("12", "pe");
//        System.out.println(tc1);
//
//        tc1.setNro_tarjeta("1234567891234567");
//        tc1.setTipo("mastercard");
//        System.out.println(tc1);
//
//        tc1.procesarPago(24.50);

        PayPal pp1 = new PayPal("paquito19@gmail.com", 20);
        System.out.println(pp1);

        pp1.procesarPago(20);

    }
}