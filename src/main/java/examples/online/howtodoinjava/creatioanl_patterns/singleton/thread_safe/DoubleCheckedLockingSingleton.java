package examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance = null;

    private DoubleCheckedLockingSingleton() {};

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Double-checking
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
