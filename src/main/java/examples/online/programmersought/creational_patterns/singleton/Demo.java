package examples.online.programmersought.creational_patterns.singleton;

import examples.online.programmersought.creational_patterns.singleton.reflection_attack_safe.AtomicSingleton;
import examples.online.wikipedia.creational_patterns.singleton.non_thread_safe.Coin;

import java.lang.reflect.Constructor;

public class Demo {
    public static void main(String[] args) throws Exception {
        AtomicSingleton singleton = AtomicSingleton.getInstance();
        singleton.setName("Tom");

        Class<AtomicSingleton> atomicSingletonClazz = AtomicSingleton.class;
        Constructor<AtomicSingleton> atomicSingletonConstructor = atomicSingletonClazz.getDeclaredConstructor();
        atomicSingletonConstructor.setAccessible(true);
        AtomicSingleton singleton1 = atomicSingletonConstructor.newInstance();
        singleton1.setName("Jerry");

        // Return "Jerry" if to leave the constructor empty in AtomicSingleton
        // otherwise throw IllegalStateException
        System.out.println(singleton.getName());
        System.out.println(singleton1.getName());

        System.out.println(AtomicSingleton.getInstance().hashCode() == AtomicSingleton.getInstance().hashCode());

    }
}
