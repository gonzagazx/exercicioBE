package org.example;

import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {
            String menu = "=== SISTEMA BANCÁRIO ===\n" +
                    "1 - Conta Corrente\n" +
                    "2 - Conta Poupança\n" +
                    "0 - Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (opcao == 1) {
                abrirContaCorrente();
            } else if (opcao == 2) {
                abrirContaPoupanca();
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema encerrado. Até logo!");
    }

    private static void abrirContaCorrente() {

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número da conta:"));
        String titular = JOptionPane.showInputDialog("Nome do titular:");
        double limite = Double.parseDouble(JOptionPane.showInputDialog("Limite da conta:"));

        ContaCorrente conta = new ContaCorrente(numero, titular, limite);

        int opcao = -1;
        while (opcao != 0) {
            String menu = "=== CONTA CORRENTE (" + conta.getTitular() + ") ===\n" +
                    "1 - Consultar saldo\n" +
                    "2 - Depositar\n" +
                    "3 - Sacar\n" +
                    "4 - Consultar limite\n" +
                    "0 - Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo: R$ " + conta.getSaldo());
                    break;

                case 2:
                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));
                    if (conta.depositar(valorDeposito)) {
                        JOptionPane.showMessageDialog(null, "Depósito realizado! Saldo: R$ " + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor inválido!");
                    }
                    break;

                case 3:
                    double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
                    if (conta.sacar(valorSaque)) {
                        JOptionPane.showMessageDialog(null, "Saque realizado! Saldo: R$ " + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Saque não permitido!");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Limite: R$ " + conta.getLimite());
                    break;
            }
        }
    }

    private static void abrirContaPoupanca() {

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número da conta:"));
        String titular = JOptionPane.showInputDialog("Nome do titular:");
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa de rendimento (%):"));

        ContaPoupanca conta = new ContaPoupanca(numero, titular, taxa);

        int opcao = -1;
        while (opcao != 0) {
            String menu = "=== CONTA POUPANÇA (" + conta.getTitular() + ") ===\n" +
                    "1 - Consultar saldo\n" +
                    "2 - Depositar\n" +
                    "3 - Sacar\n" +
                    "4 - Aplicar rendimento\n" +
                    "0 - Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo: R$ " + conta.getSaldo());
                    break;

                case 2:
                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));
                    if (conta.depositar(valorDeposito)) {
                        JOptionPane.showMessageDialog(null, "Depósito realizado! Saldo: R$ " + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor inválido!");
                    }
                    break;

                case 3:
                    double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
                    if (conta.sacar(valorSaque)) {
                        JOptionPane.showMessageDialog(null, "Saque realizado! Saldo: R$ " + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                    }
                    break;

                case 4:
                    conta.aplicarRendimento();
                    JOptionPane.showMessageDialog(null, "Rendimento aplicado! Novo saldo: R$ " + conta.getSaldo());
                    break;
            }
        }
    }
}


