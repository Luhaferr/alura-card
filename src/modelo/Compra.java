package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Compra{
    private CartaoCredito cartao; //objeto CartaoCredio
    private String item;
    private double valorDaCompra;
    private double totalCompra;

    List<Compra> listaCompras = new ArrayList<>();

    /*
     Construtor que recebe o CartaoCredito permitindo a Composição para que a instância da classe Compra seja associada
     a uma instância específica de CartaoCredito e por essa associação consiga usar métodos de CartaoCredito
     para consultar e atualizar o limite/saldo.
     */
    public Compra(CartaoCredito cartaoCredito) {
        this.cartao = cartaoCredito;
    }

    public Compra(String item, double valorDaCompra) {
        this.item = item;
        this.valorDaCompra = valorDaCompra;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }
    public List adicionarCompra(String item, double valorDaCompra) {
        //verifica o limite no CartaoCredito
        if (cartao.getLimite() >= valorDaCompra) {
            listaCompras.add(new Compra(item, valorDaCompra)); //adiciona compra
            System.out.println("Compra realizada");
            cartao.novoSaldo(valorDaCompra); // // Atualiza o saldo no cartão ao fazer uma compra
        }
        else {
            System.out.println("Saldo insuficiente!");
            exibirLista();
        }
        return listaCompras;
    }

    public double totalCompra() {
        for (Compra valorDaCompra : listaCompras){
            this.totalCompra += valorDaCompra.getValorDaCompra();
        }
        return totalCompra;
    }
    public void exibirLista() {
        listaCompras.sort(Comparator.comparing(Compra::getValorDaCompra)); //ordenação por valor de compra
        System.out.println("********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (Compra item : listaCompras) {
            System.out.println(item.item + " - " + item.valorDaCompra);
        }
        System.out.println("\n********************\n");
        System.out.println("Saldo do cartão: " + cartao.getLimite());
    }
}
