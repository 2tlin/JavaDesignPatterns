package examples.books.refactoring_guru.memento.example.commands;

public interface Command {
    String getName();
    void execute();
}
