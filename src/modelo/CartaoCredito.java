package modelo;

public class CartaoCredito {
    private double limite;

    public CartaoCredito(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void novoSaldo(double valorDaCompra){
        this.limite -= valorDaCompra;
        System.out.println("Saldo do cartão: " + limite);
    }
}