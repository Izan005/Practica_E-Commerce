package org.example;

public class PayPal extends MetodoPago{
    final double SALDO_DEF = 23;

    private String cuenta;
    private double saldo;

    public PayPal(String cuenta, double saldo){
        this.cuenta=comprobarCuenta(cuenta);
        this.saldo=saldo;
    }

    public PayPal(String cuenta){
        this.cuenta=comprobarCuenta(cuenta);
        saldo=SALDO_DEF;
    }

    public String comprobarCuenta(String cuenta){

        if(cuenta.matches(".*@*\\.com")){
            return cuenta;
        }
        System.out.println("Formato de cuenta incorrecto. Hasta que lo cambies, se asignará un valor por defecto a la cuenta.");
        return "xxx@xxx.com";
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = comprobarCuenta(cuenta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    void procesarPago(double importe) {

        if (saldo >= importe){
            System.out.println("Procesando pago de importe " + importe + "€ con PayPal.");
        } else {
            System.out.println("ERROR. Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "PayPal{" +
                "cuenta='" + cuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
