package examples.books.refactoring_guru.abstract_factory.example.app;

import examples.books.refactoring_guru.abstract_factory.example.buttons.Button;
import examples.books.refactoring_guru.abstract_factory.example.checkboxes.Checkbox;
import examples.books.refactoring_guru.abstract_factory.example.factories.GUIFactory;

/**
 * Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает.
 * Все получатели продуктов работают с продуктами через абстрактный интерфейс.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
