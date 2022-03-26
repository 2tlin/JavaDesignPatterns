package examples.books.refactoring_guru.visitor.example.visitor;

import examples.books.refactoring_guru.visitor.example.shapes.Circle;
import examples.books.refactoring_guru.visitor.example.shapes.CompoundShape;
import examples.books.refactoring_guru.visitor.example.shapes.Dot;
import examples.books.refactoring_guru.visitor.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
