package org.example;

public class ContaCorrente extends ContaBancaria {

    private double limite;


    public ContaCorrente() {
        super();
        this.limite = 0;
    }




    public ContaCorrente(int numero, String titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite + getSaldo() ;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public boolean sacar(double valor) {
        double disponivel = getSaldo() + getLimite();

        if (valor > 0 && valor <= disponivel) {
            diminuirSaldo(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Limite: R$ " + String.format("%.2f", limite);
    }
}

