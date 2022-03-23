package books.refactoring_guru.visitor.example.shapes;

import books.refactoring_guru.visitor.example.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
