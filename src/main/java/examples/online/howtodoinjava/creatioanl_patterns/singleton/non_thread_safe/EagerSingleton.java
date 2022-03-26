package examples.online.howtodoinjava.creatioanl_patterns.singleton.non_thread_safe;
/*
1. Singleton with eager initialization
This is a design pattern where an instance of a class is created much before it is actually required.
Mostly it is done on system startup. In an eager initialization singleton pattern, the singleton instance is created
irrespective of whether any other class actually asked for its instance or not.

The above method works fine, but it has one drawback. The instance is created irrespective of it is required in runtime or not.
If this instance is not a big object and you can live with it being unused, this is the best approach.

Volatile:
Please be sure to use “volatile” keyword with instance variable otherwise you can run into an out of order write error scenario,
where reference of an instance is returned before actually the object is constructed i.e.
JVM has only allocated the memory and constructor code is still not executed.
In this case, your other thread, which refers to the uninitialized object may throw null pointer exception
 and can even crash the whole application.
 */

public class EagerSingleton {
    private static volatile EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {};

    public static EagerSingleton getInstance() {
        return instance;
    }
}
