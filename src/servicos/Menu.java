package servicos;

import modelo.CartaoCredito;
import modelo.Compra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private CartaoCredito cartaoCredito;
    private Compra compra;
    Scanner scanner = new Scanner(System.in);

    // Construtor que inicializa o CartaoCredito e Compra garantindo que Compra use o mesmo Cartao
    public Menu(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito; //recebe um CartaoCredito
        this.compra = new Compra(cartaoCredito); // inicializa uma Compra com esse CartaoCredito quando Menu é instanciado
    }

    public void iniciarMenu(){
        System.out.println("Digite a descrição da compra:");
        String item = scanner.nextLine();

        System.out.println("Digite o valor da compra:");
        double valorDaCompra = scanner.nextDouble();
        scanner.nextLine();//limpa o buffer para evitar problema na próxima leitura

        compra.adicionarCompra(item, valorDaCompra);

        System.out.println("Digite 0 para sair ou 1 para continuar");
        int n = scanner.nextInt();
        scanner.nextLine();//limpa o buffer para evitar problema na próxima leitura

        try {
            if (n == 0) {
                compra.exibirLista();
            }
            if (n == 1) {
                iniciarMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida!");
        }

    }
}
