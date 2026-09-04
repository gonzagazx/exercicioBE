package org.example;

public class ContaPoupanca extends ContaBancaria {

    private double taxaRendimento;


    public ContaPoupanca() {
        super();
        this.taxaRendimento = 0;
    }


    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
        this.taxaRendimento = 0;
    }


    public ContaPoupanca(int numero, String titular, double taxaRendimento) {
        super(numero, titular);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }


    public void aplicarRendimento() {
        double rendimento = getSaldo() * (taxaRendimento / 100.0);
        aumentarSaldo(rendimento);
    }

    @Override
    public String toString() {
        return super.toString() + " - Taxa de rendimento: " + taxaRendimento + "%";
    }
}

