package homework.сreational_patterns.singleton;

import homework.сreational_patterns.singleton.non_thread_safe.CoinDemo;
import homework.сreational_patterns.singleton.non_thread_safe.SingletonNonSyncronizedDemo;
import homework.сreational_patterns.singleton.thread_safe.SingletonSyncronizedAtomicDemo;
import homework.сreational_patterns.singleton.thread_safe.SingletonSyncronizedDemo;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

        for (int i: List.of(1,2,3)) {
            var coin1 = CoinDemo.getInstance();
            System.out.println(coin1.getCoin()); // 0

            var coin2 = CoinDemo.getInstance();
            coin2.addCoins(); // + 10
            System.out.println(coin2.getCoin()); // 10

            var coin3 = CoinDemo.getInstance();
            coin3.deductCoins(); // -10
            System.out.println(coin3.getCoin()); // 0

            System.out.println(coin1.hashCode() == coin2.hashCode() &&  coin2.hashCode() == coin3.hashCode()); // true

            System.out.println("-------------------");
        }

        for (int i = 0; i < 10; i++) {
            new Thread(CoinDemo.getInstance()).start();
        }
        System.out.println(CoinDemo.getInstance().getCoin());

        System.out.println("-------------------");

        for (int i = 0; i < 10; i++) {
            new Thread(SingletonNonSyncronizedDemo.getInstance()).start();
        }
        System.out.println(SingletonNonSyncronizedDemo.getInstance().getCounter());

        System.out.println("-------------------");

        for (int i = 0; i < 10; i++) {
            new Thread(SingletonSyncronizedDemo.getInstance()).start();
        }
        System.out.println(SingletonSyncronizedDemo.getInstance().getCounter());

        System.out.println("-------------------");

        for (int i = 0; i < 10; i++) {
            new Thread(SingletonSyncronizedAtomicDemo.getInstance()).start();
        }
        System.out.println(SingletonSyncronizedAtomicDemo.getInstance().getCounter());
    }
}
