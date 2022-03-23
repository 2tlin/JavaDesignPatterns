package online.wikipedia.creational_patterns.singleton.thread_safe;
/*
Lazy initialization
A singleton implementation may use lazy initialization, where the instance is created when the static method is first invoked.

If the static method might be called from multiple threads simultaneously, measures may need to be taken to prevent race conditions
that could result in the creation of multiple instances.

The following is a thread-safe implementation, using lazy initialization with double-checked locking, written in Java.
In order to avoid the synchronization overhead while keeping lazy initialization with thread safety,
the preferred approach in Java is to use the initialization-on-demand holder idiom.

https://en.wikipedia.org/wiki/Double-checked_locking
double-checked locking optimization
In software engineering, double-checked locking (also known as "double-checked locking optimization"[1])
is a software design pattern used to reduce the overhead of acquiring a lock by testing the locking criterion (the "lock hint")
before acquiring the lock. Locking occurs only if the locking criterion check indicates that locking is required.

The pattern, when implemented in some language/hardware combinations, can be unsafe. At times, it can be considered an anti-pattern.[2]

It is typically used to reduce locking overhead when implementing "lazy initialization" in a multi-threaded environment,
especially as part of the Singleton pattern. Lazy initialization avoids initializing a value until the first time it is accessed.
*/

public class Singleton {
    // thread-safe implementation, using lazy initialization with double-checked locking
    private static volatile Singleton instance = null;

    private Singleton() {};

    public static Singleton getInstance() {
        if (instance == null) { //  testing the locking criterion (the "lock hint") before acquiring the lock
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
