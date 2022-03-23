package books.refactoring_guru.mediator.example.components;

import books.refactoring_guru.mediator.example.mediator.Mediator;

/**
 * Общий интерфейс компонентов.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
