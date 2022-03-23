package online.wikipedia.creational_patterns.singleton.non_thread_safe;
/*
Implementations of the singleton pattern must:

- Ensure that only one instance of the singleton class ever exists; and
- Provide global access to that instance.
Typically, this is done by:

- Declaring all constructors of the class to be private; and
- Providing a static method that returns a reference to the instance.
The instance is usually stored as a private static variable; the instance is created when the variable is initialized, at some point before the static method is first called.

Java
Singleton implementation in Java:[10]
 */
public class Coin {
    private static final int ADD_MORE_COIN = 10;
    private int coin;
    private static final Coin instance = new Coin(); // eargly loads the singleton

    private Coin() {}; // private to prevent anyone else from instantiating


    public int getCoin() {
        return coin;
    }

    public static Coin getInstance() {
        return instance;
    }

    public void addMoreCoin() {
        coin += ADD_MORE_COIN;
    }

    public void deductCoin() {
        coin--;
    }
}
