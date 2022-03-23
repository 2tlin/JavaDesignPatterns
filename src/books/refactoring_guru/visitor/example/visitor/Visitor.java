package books.refactoring_guru.visitor.example.visitor;

import books.refactoring_guru.visitor.example.shapes.Circle;
import books.refactoring_guru.visitor.example.shapes.CompoundShape;
import books.refactoring_guru.visitor.example.shapes.Dot;
import books.refactoring_guru.visitor.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
