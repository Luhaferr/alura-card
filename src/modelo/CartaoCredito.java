package modelo;

import java.util.Scanner;

public class CartaoCredito {
    Scanner scanner = new Scanner(System.in);
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite() {
        System.out.println("Digite o limite do cartão:");
        this.limite = scanner.nextDouble();
    }
    public void novoSaldo(double valorDaCompra){
        this.limite -= valorDaCompra;
        System.out.println("Saldo do cartão: " + limite);
    }
}