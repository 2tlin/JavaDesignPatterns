package examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe;

import java.io.Serial;

/*
7. Add serialVersionUId to singleton objects
So far so good. Untill now, we have solved both of the problems of synchronization and serialization.
Now, we are just one step away from a correct and complete implementation.
The only missing part is a serial version id.

This is required in cases where your class structure changes between serialization and deserialization.
A changed class structure will cause the JVM to give an exception in the de-serializing process.

This problem can be solved only by adding a unique serial version id to the class.
It will prevent the compiler from throwing the exception by telling it that both classes are same,
and will load the available instance variables only.
 */
public class DemoSingleton {
    // to prevent the compiler from throwing the exception by telling it that both classes are same
    private static final long serialVersionUID = 1L;

    // to prevent creating a new instance outside
    private DemoSingleton() {};

    private static class DemoSingletonHolder {
        // “Initialization-on-demand holder idiom”
        private static final DemoSingleton INSTANCE = new DemoSingleton();
    }

    // public API to create an instance
    public static DemoSingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }

    @Serial
    protected Object readResolver() {
        // this method is part of the serialization mechanism defined by the Java Object Serialization Specification.
        return getInstance();
    }
}
