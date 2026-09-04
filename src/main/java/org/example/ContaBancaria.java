package org.example;

public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;


    public ContaBancaria() {
        this.numero = 0;
        this.titular = "";
        this.saldo = 0;
    }


    public ContaBancaria(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }


    public double getSaldo() {
        return saldo;
    }

    // ---------- Métodos protegidos para as subclasses alterarem o saldo ----------


    protected void aumentarSaldo(double valor) {
        this.saldo += valor;
    }


    protected void diminuirSaldo(double valor) {
        this.saldo -= valor;
    }




    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }


    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta " + numero + " - Titular: " + titular + " - Saldo: R$ " + String.format("%.2f", saldo);
    }
}
