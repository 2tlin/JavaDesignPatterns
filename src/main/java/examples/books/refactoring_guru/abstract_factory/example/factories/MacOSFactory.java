package examples.books.refactoring_guru.abstract_factory.example.factories;

import examples.books.refactoring_guru.abstract_factory.example.buttons.Button;
import examples.books.refactoring_guru.abstract_factory.example.buttons.MacOSButton;
import examples.books.refactoring_guru.abstract_factory.example.checkboxes.Checkbox;
import examples.books.refactoring_guru.abstract_factory.example.checkboxes.MacOSCheckbox;

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
