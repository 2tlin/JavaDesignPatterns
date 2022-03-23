package homework.сreational_patterns.singleton.non_thread_safe;

public class CoinDemo implements Runnable {
    private int coin;
    private final static int COINS = 10;
    private final static int ONE_COIN = 1;

    private final static CoinDemo instance = new CoinDemo();

    private CoinDemo() {};

    public static CoinDemo getInstance() {
        return instance;
    }

    public int getCoin() {
        return this.coin;
    }

    public void addCoins() {
        coin += COINS;
    }

    public void deductCoins() {
        coin -= COINS;
    }

    public void increment() {
        coin += ONE_COIN;
    }

    public void decrement() {
        coin -= ONE_COIN;
    }

    @Override
    public void run() {
        instance.increment();
    }
}
