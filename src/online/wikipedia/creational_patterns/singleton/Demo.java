package online.wikipedia.creational_patterns.singleton;

import online.wikipedia.creational_patterns.singleton.non_thread_safe.Coin;
import online.wikipedia.creational_patterns.singleton.non_thread_safe.Singleton;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode() == Singleton.getInstance().hashCode());

        System.out.println(Coin.getInstance().hashCode());
        System.out.println(Coin.getInstance().hashCode() == Coin.getInstance().hashCode());
    }
}
