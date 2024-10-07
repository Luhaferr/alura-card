package servicos;

import modelo.CartaoCredito;
import modelo.Compra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private CartaoCredito cartaoCredito;
    private Compra compra;
    Scanner scanner = new Scanner(System.in);

//    // Construtor que inicializa o CartaoCredito e Compra garantindo que Compra use o mesmo Cartao
//    public Menu(CartaoCredito cartaoCredito) {
//        this.cartaoCredito = cartaoCredito; //recebe um CartaoCredito
//        this.compra = new Compra(cartaoCredito); // inicializa uma Compra com esse CartaoCredito quando Menu é instanciado
//    }

    public void iniciarCartao(){
        System.out.println("Digite o limite do cartão:");
        //validação de entradas
        try {
            double limite = scanner.nextDouble();
            scanner.nextLine();//limpa o buffer para evitar problema na próxima leitura
            if (limite > 0) {
                cartaoCredito = new CartaoCredito(limite); //Inicializa o cartão com o limite
                compra = new Compra(cartaoCredito); //Inicializa o cartão com o limite
            }
            else {
                System.out.println("O limite precisa ser maior que zero!");
                iniciarCartao(); // Chama o método novamente para reiniciar a entrada
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Insira um valor válido!");
            scanner.next();
            iniciarCartao();
        }
    }
    public void iniciarMenu(){
        //Garante que o cartão de crédito está inicializado antes de começar
        if (cartaoCredito == null) {
            System.out.println("Inicializando o menu...");
            iniciarCartao();
        }

        System.out.println("Digite a descrição da compra:");
        String item = scanner.nextLine();

        System.out.println("Digite o valor da compra:");
        //validação de entradas
        try {
            double valorDaCompra = scanner.nextDouble();
            scanner.nextLine();//limpa o buffer para evitar problema na próxima leitura

            if (valorDaCompra > 0) {
                compra.adicionarCompra(item, valorDaCompra);
            }
            else {
                System.out.println("O valor da compra deve ser positivo!");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Insira um valor numérico válido!");
            scanner.next(); // Limpa a entrada inválida do scanner
        }

        System.out.println("Digite 0 para sair ou 1 para continuar");
        int n = scanner.nextInt();
        scanner.nextLine();//limpa o buffer para evitar problema na próxima leitura
        switch (n) {
            case 0:
                compra.exibirLista();
                break;
            case 1:
                iniciarMenu();
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }
}
