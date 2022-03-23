package homework.сreational_patterns.singleton.thread_safe;

public class SingletonSyncronizedDemo implements Runnable {
    // thread-safe implementation, using lazy initialization with double-checked locking
    private static volatile SingletonSyncronizedDemo instance = null;
    private long counter; // non thread safe counter !!!

    private SingletonSyncronizedDemo() {};

    public static SingletonSyncronizedDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonSyncronizedDemo.class) {
                if (instance == null) {
                    instance = new SingletonSyncronizedDemo();
                }
            }
        }
        return instance;
    }

    public void incrementCounter() {
        counter += 1;
    }

    public long getCounter() {
        return counter;
    }

    @Override
    public void run() {
        instance.incrementCounter();
    }
}
