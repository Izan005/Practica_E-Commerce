package org.example;

import java.util.Random;

public class Bizum extends MetodoPago{

    static Random rdm = new Random();

    private String telefono;
    private int pin;

    public Bizum(String telefono){
        this.telefono=comprobarTelefono(telefono);
        pin= rdm.nextInt(100000, 999999)+1;
        System.out.println("Pin generado: " + pin);
    }

    public String comprobarTelefono(String telefono){
        if (telefono.length() != 9){
            System.out.println("Formato de teléfono incorrecto. Se asignará un valor por defecto" +
                    "al número hasta un nuevo cambio.");
            return "XXXXXXXXX";
        }
        return telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de importe " + importe + "€ con Bizum.");
    }
}
