package books.refactoring_guru.abstract_factory.example.factories;

import books.refactoring_guru.abstract_factory.example.buttons.Button;
import books.refactoring_guru.abstract_factory.example.checkboxes.Checkbox;

/**
 * Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
