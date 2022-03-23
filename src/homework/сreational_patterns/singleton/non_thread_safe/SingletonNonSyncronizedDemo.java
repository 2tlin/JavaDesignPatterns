package homework.сreational_patterns.singleton.non_thread_safe;

public class SingletonNonSyncronizedDemo implements Runnable {
    // thread-safe implementation, using lazy initialization with double-checked locking
    private static volatile SingletonNonSyncronizedDemo instance = null;
    private long counter; // non thread safe counter !!!

    private SingletonNonSyncronizedDemo() {};

    public static SingletonNonSyncronizedDemo getInstance() {
        if (instance == null) {
            instance = new SingletonNonSyncronizedDemo();
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
