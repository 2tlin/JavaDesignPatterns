package examples.books.java_programm_design_by_edward_sciore.version6_transparency_rule_and_open_closed_rule_and_absraction_rule;

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

    @Override
    public int compareTo(BankAccount ba) {
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        /*
        The compareTo method needs to return a positive number if bal1>bal2
        and a negative number if bal2>bal1. Subtracting the two balances has the
        desired effect. If the two balances are equal then the method uses their
        account numbers to arbitrarily break the tie. Thus, the method will return
        0 only if the comparison is between objects corresponding to the same
        account. This is the expected behavior of any compareTo method.
         */
        if (bal1 == bal2)
            return getAcctNum() - ba.getAcctNum();
        else
            return bal1 - bal2;
    }
}
