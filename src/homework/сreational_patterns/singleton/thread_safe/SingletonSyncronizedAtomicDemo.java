package homework.сreational_patterns.singleton.thread_safe;

import java.util.concurrent.atomic.AtomicLong;

public class SingletonSyncronizedAtomicDemo implements Runnable {
    private static volatile SingletonSyncronizedAtomicDemo instance = null;
    private static final AtomicLong counter = new AtomicLong(1);

    private SingletonSyncronizedAtomicDemo() {};

    public static SingletonSyncronizedAtomicDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonSyncronizedAtomicDemo.class) {
                if (instance == null) {
                    instance = new SingletonSyncronizedAtomicDemo();
                }
            }
        }
        return instance;
    }

    public long incrementCounter() {
        return counter.getAndIncrement();
    }

    public AtomicLong getCounter() {
        return counter;
    }

    @Override
    public void run() {
        instance.incrementCounter();
        System.out.println();
    }
}
