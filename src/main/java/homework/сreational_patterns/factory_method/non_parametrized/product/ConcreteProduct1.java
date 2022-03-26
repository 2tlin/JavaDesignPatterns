package homework.сreational_patterns.factory_method.non_parametrized.product;

public class ConcreteProduct1 implements Product {
    @Override
    public void methodOne4product() {
        System.out.println("This is odd number and methodOne4product of ConcreteProduct1 class");
    }

    @Override
    public void methodTwo4product() {
        System.out.println("This is odd number and methodTwo4product of ConcreteProduct1 class");
    }
}
