package examples.online.programmersought.creational_patterns.singleton.reflection_attack_safe;

import java.util.concurrent.atomic.AtomicReference;

/*
AtomicReference
According to the API description, it is a class that can guarantee the atomicity of object updates.
Atomic means that multiple threads trying to change the same AtomicReference will not cause thread safety issues.

AtomicReference has a very common method: compareAndSet, this method accepts two parameters,
the first parameter is the expected value, the second parameter is the value you want to set,
the meaning of this method is to update the value in AtomicReference to The value passed by the second parameter,
when the current value is the expected value, if the update is successful, it returns true,
otherwise it returns false
 */
public class AtomicSingleton {
    private static final AtomicReference<AtomicSingleton> INSTANCE = new AtomicReference<>();

    public static AtomicSingleton getInstance() {
        AtomicSingleton current = INSTANCE.get();
        if (current == null)   {
            current = new AtomicSingleton();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
        return current;
    }

    private AtomicSingleton() {
        // to prevent reflection attack
        IllegalStateException illegalStateException = new IllegalStateException(
                "Невозможно вызвать конструктор, используйте getInstance (), чтобы получить экземпляр»)"
        );

        StackTraceElement[] stackElements = illegalStateException.getStackTrace();

        if (stackElements != null && !stackElements[1].getClassName().equals(getClass().getName())) {
            throw illegalStateException;
        }
    }

    // Добавлены переменные-члены
    private String name;

    // метод setter / getter
    public String getName() {
        return name;
    }

    public AtomicSingleton setName(String name) {
        this.name = name;
        return this;
    }
}
