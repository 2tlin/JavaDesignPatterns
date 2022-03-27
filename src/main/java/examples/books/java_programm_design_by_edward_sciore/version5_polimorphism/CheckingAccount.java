package examples.books.java_programm_design_by_edward_sciore.version5_polimorphism;

public class CheckingAccount implements BankAccount {
    // the rate variable is omitted
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;

    public CheckingAccount(int acctnum) {
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
        return balance >= 2 * loanamt / 3;
    }

    public String toString() {
        return "Checking account "
                + acctnum + ": balance="
                + balance + ", is "
                + (isforeign ? "foreign" : "domestic");
    }

}
