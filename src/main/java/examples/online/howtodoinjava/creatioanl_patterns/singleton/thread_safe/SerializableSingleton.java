package examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe;

import java.io.Serial;
import java.io.Serializable;

/*
6. Add readResolve() to Singleton Objects
By now you must have made your decision about how you would like to implement your singleton.
Now let’s see other problems that may arise even in job interviews.

Let’s say your application is distributed and it frequently serializes objects into the file system,
only to read them later when required. Please note that de-serialization always creates a new instance.

Unfortunately, both variables have different values of the variable “i”. Clearly, there are two instances of our class.
So, again we are in the same problem of multiple instances in our application.

To solve this issue, we need to include a readResolve() method in our DemoSingleton class.
This method will be invoked when you will de-serialize the object.
Inside of this method, you must return the existing instance to ensure a single instance application wide.

 */
public class SerializableSingleton implements Serializable {
    private static volatile SerializableSingleton instance = null;

    private SerializableSingleton() {};

    public static SerializableSingleton getInstance() {
        if (instance == null) {
            instance = new SerializableSingleton();
        }
        return instance;
    }

    /*
    Indicates that an annotated field or method is part of the serialization mechanism defined by the Java Object Serialization Specification.
    This annotation type is intended to allow compile-time checking of serialization-related declarations.
     */
    @Serial
    protected Object readResolve() {
        // this method is part of the serialization mechanism defined by the Java Object Serialization Specification.
        return instance;
    }

    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
