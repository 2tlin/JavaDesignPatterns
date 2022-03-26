package homework.сreational_patterns.factory_method.non_parametrized.creator;

import homework.сreational_patterns.factory_method.non_parametrized.product.ConcreteProduct1;
import homework.сreational_patterns.factory_method.non_parametrized.product.Product;

public class ConcreteCreator1 extends Creator {
    @Override
    public Product creatorProduct() {
        return new ConcreteProduct1();
    }
}


