package examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe;
/*
4. Singleton with bill pugh solution
Bill Pugh was main force behind the java memory model changes.
His principle “Initialization-on-demand holder idiom” also uses the static block idea, but in a different way.
It suggest to use static inner class.

As you can see, until we need an instance, the LazyHolder class will not be initialized until required
and you can still use other static members of BillPughSingleton class.
This is the solution, i will recommend to use. I have used it in my all projects.

Initialization-on-demand holder idiom
The implementation of the idiom relies on the initialization phase of execution within the Java Virtual Machine (JVM)
as specified by the Java Language Specification (JLS).[3] When the class Something is loaded by the JVM,
the class goes through initialization. Since the class does not have any static variables to initialize,
the initialization completes trivially. The static class definition LazyHolder within it is not initialized
 until the JVM determines that LazyHolder must be executed. The static class LazyHolder is only executed
 when the static method getInstance is invoked on the class Something, and the first time this happens
 the JVM will load and initialize the LazyHolder class.

 The initialization of the LazyHolder class results in static variable INSTANCE being initialized
 by executing the (private) constructor for the outer class Something.
 Since the class initialization phase is guaranteed by the JLS to be sequential,
 i.e., non-concurrent, no further synchronization is required in the static getInstance method during loading and initialization.
 And since the initialization phase writes the static variable INSTANCE in a sequential operation,
 all subsequent concurrent invocations of the getInstance will return the same correctly initialized INSTANCE
  without incurring any additional synchronization overhead.

  While the implementation is an efficient thread-safe "singleton" cache without synchronization overhead,
  and better performing than uncontended synchronization,[4] 
  the idiom can only be used when the construction of Something is guaranteed to not fail. 
  In most JVM implementations, if construction of Something fails, subsequent attempts to initialize 
  it from the same class-loader will result in a NoClassDefFoundError failure.
 */
public class InitializationOnDemandHolderSingleton {
    private InitializationOnDemandHolderSingleton() {};

    private static class LazyHolder {
        private static final InitializationOnDemandHolderSingleton INSTANCE = new InitializationOnDemandHolderSingleton();
    }

    public static InitializationOnDemandHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
