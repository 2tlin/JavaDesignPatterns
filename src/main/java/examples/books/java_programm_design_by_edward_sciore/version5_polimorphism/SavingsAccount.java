package examples.books.java_programm_design_by_edward_sciore.version5_polimorphism;

public class SavingsAccount implements BankAccount {

    private int acctnum;
    private int balance = 0;
    private double rate = 0.01;
    private boolean isforeign = false;

    public SavingsAccount(int acctnum) {
        this.acctnum = acctnum;
    }

    public int getAcctNum() {
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

    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= loanamt / 2;
    }

    public String toString() {
        return "Saving account "
                + acctnum + ": balance="
                + balance + ", is "
                + (isforeign ? "foreign" : "domestic");
    }

    public void addInterest() {
        balance += (int) (balance * rate);
    }
}
