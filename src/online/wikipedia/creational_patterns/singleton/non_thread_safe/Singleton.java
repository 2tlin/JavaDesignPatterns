package online.wikipedia.creational_patterns.singleton.non_thread_safe;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {};

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
