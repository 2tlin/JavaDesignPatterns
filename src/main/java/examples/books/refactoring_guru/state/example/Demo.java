package examples.books.refactoring_guru.state.example;

import examples.books.refactoring_guru.state.example.ui.Player;
import examples.books.refactoring_guru.state.example.ui.UI;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
