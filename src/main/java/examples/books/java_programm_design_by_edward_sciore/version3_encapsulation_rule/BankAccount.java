package examples.books.java_programm_design_by_edward_sciore.version3_encapsulation_rule;

public class BankAccount {
    // Why not just use public variables, with this class, a client could simply access
    // BankAccount’s variables directly instead of having to call its methods.
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;

    public BankAccount(int a) {
        acctnum = a;
    }

    public int getAcctnum() {
        return acctnum;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isforeign;
    }

    public void setForeign(boolean isforeign) {
        this.isforeign = isforeign;
    }
}
