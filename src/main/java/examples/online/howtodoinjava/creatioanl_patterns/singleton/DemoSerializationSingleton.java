package examples.online.howtodoinjava.creatioanl_patterns.singleton;

import examples.online.howtodoinjava.creatioanl_patterns.singleton.thread_safe.SerializableSingleton;

import java.io.*;

public class DemoSerializationSingleton {
    static SerializableSingleton instanceOne = SerializableSingleton.getInstance();

    public static void main(String[] args) {

        try (
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("resources/filename.ser"));
            ObjectInput in = new ObjectInputStream(new FileInputStream("resources/filename.ser"));
        ) {
            // Serialize to a file
            out.writeObject(instanceOne);

            instanceOne.setI(20);

            // Serialize to a file
            // New instance every time with deserialization
            SerializableSingleton instanceTwo = (SerializableSingleton) in.readObject();

            // Without readResolve is not equal
            System.out.println(instanceOne.getI());
            System.out.println(instanceTwo.getI());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
