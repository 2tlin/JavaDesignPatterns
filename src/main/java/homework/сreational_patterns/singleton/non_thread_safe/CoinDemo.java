package homework.сreational_patterns.singleton.non_thread_safe;

public class CoinDemo  {
    private int coin;
    private final static int COINS = 10;

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
}
