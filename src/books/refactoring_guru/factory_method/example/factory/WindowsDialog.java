package books.refactoring_guru.factory_method.example.factory;

import books.refactoring_guru.factory_method.example.buttons.Button;
import books.refactoring_guru.factory_method.example.buttons.WindowsButton;

/**
 * Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
