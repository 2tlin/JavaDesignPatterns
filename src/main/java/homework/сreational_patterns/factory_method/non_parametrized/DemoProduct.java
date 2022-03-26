package homework.сreational_patterns.factory_method.non_parametrized;

import homework.сreational_patterns.factory_method.non_parametrized.creator.ConcreteCreator1;
import homework.сreational_patterns.factory_method.non_parametrized.creator.ConcreteCreator2;
import homework.сreational_patterns.factory_method.non_parametrized.creator.Creator;

import java.io.IOException;

public class DemoProduct {
    private static Creator creator;

    public static void main(String[] args) throws IOException {
        configure();
        runBusinessLogic();
    }

    /**
     * Приложение создаёт определённую фабрику в зависимости от конфигурации или окружения.
     */
    static void configure() throws IOException {
        System.out.println("Enter number from 1 to 10");
        int i = System.in.read();
        if (i % 2 != 0) { // even
            creator = new ConcreteCreator1();
        } else { // odd
            creator = new ConcreteCreator2();
        }
    }

    /**
     * Весь остальной клиентский код работает с фабрикой и продуктами только
     * через общий интерфейс, поэтому для него неважно какая фабрика была
     * создана.
     */
    static void runBusinessLogic() {
        creator.commonLogic();
        creator.creatorProduct().methodTwo4product();
    }
}
