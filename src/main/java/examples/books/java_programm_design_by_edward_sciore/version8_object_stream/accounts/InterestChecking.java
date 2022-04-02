package examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts;

public class InterestChecking extends AbstractCheckingAccount {
    private double rate = 0.01;

    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    public String toString() {
        return "Interest checking account " + getAcctNum()
                + ": balance=" + getBalance() + ", is "
                + (isForeign() ? "foreign" : "domestic");
    }
    public void addInterest() {
        int newbalance = (int) (getBalance() * rate);
        deposit(newbalance);
    }
}
