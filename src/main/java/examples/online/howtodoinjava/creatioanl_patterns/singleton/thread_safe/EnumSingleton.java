package examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe;
/*
5. Singleton using Enum
This type of implementation employs the use of enum. Enum, as written in the java docs,
provided implicit support for thread safety and only one instance is guaranteed.
Java enum singleton is also a good way to have singleton with minimal effort.
 */
public enum EnumSingleton {
    INSTANCE;
    public void someMethod(String param) {
        //
    }
}
