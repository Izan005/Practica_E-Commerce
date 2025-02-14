package org.example;

public class TarjetaCredito extends MetodoPago {

    private String nro_tarjeta;
    private String tipo;

    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta = comprobarNumTarjeta(nro_tarjeta);
        this.tipo = comprobarTipo(tipo);
    }


    public String comprobarNumTarjeta(String nro_tarjeta){

        if (nro_tarjeta.length() != 16){
            System.out.println("Número de tarjeta no válido. El número será null hasta que el número sea correcto.");
            return null;
        }
        return nro_tarjeta;
    }

    public String comprobarTipo(String tipo){

        if (tipo.equalsIgnoreCase("VISA") || tipo.equalsIgnoreCase("MASTERCARD")
        || tipo.equalsIgnoreCase("MAESTRO")){
            return tipo;
        }
        System.out.println("Tipo no válido. El tipo será null hasta que el tipo sea correcto.");
        return null;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = comprobarNumTarjeta(nro_tarjeta);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = comprobarTipo(tipo);
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de importe " + importe + "€ con tarjeta de crádito " + tipo);
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "nro_tarjeta='" + nro_tarjeta + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
