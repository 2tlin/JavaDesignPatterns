package examples.books.refactoring_guru.factory_method.example.factory;

import examples.books.refactoring_guru.factory_method.example.buttons.Button;
import examples.books.refactoring_guru.factory_method.example.buttons.HtmlButton;

/**
 * HTML-диалог.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
