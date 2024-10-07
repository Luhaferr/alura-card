package application;

import modelo.CartaoCredito;
import servicos.Menu;

public class Main {
    public static void main(String[] args) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setLimite();

        Menu menu = new Menu(cartaoCredito);
        menu.iniciarMenu();
    }
}