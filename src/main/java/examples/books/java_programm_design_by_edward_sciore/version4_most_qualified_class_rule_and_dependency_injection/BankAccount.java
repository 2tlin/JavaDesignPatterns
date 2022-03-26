package examples.books.java_programm_design_by_edward_sciore.version4_most_qualified_class_rule_and_dependency_injection;

public class BankAccount {

    private int acctnum;
    private int balance = 0;
    private double rate = 0.01;
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

    public void setForeign(boolean isForeign) {
        this.isforeign = isForeign;
    }

    public void deposit(int amt) {
        balance += amt;
    }

    public boolean hasEnoughCollateral(int amt) {
        return balance >= amt / 2;
    }

    public String toString() {
        return "Bank account "
                + acctnum + ": balance="
                + balance + ", is "
                + (isforeign ? "foreign" : "domestic");
    }

    public void addInterest() {
        balance += (int) (balance * rate);
    }
}
