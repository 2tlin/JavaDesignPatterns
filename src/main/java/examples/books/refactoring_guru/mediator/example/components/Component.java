package examples.books.refactoring_guru.mediator.example.components;

import examples.books.refactoring_guru.mediator.example.mediator.Mediator;

/**
 * Общий интерфейс компонентов.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
