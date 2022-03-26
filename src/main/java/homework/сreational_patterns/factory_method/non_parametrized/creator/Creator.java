package homework.сreational_patterns.factory_method.non_parametrized.creator;

import homework.сreational_patterns.factory_method.non_parametrized.product.Product;

public abstract class Creator {
    public abstract Product creatorProduct();

    public void commonLogic() {
        System.out.println("This is common business logic for both Product");
    }
}
