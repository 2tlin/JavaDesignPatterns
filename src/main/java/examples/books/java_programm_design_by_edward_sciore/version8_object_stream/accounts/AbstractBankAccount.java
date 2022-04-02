package examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts;

public abstract class  AbstractBankAccount implements BankAccount {
    /*
    Java provides the modifier protected
    as an alternative to public or private. A protected variable is accessible
    to its descendent classes in the hierarchy but not to any other classes
     */
    protected int acctnum;
    protected int balance = 0;
    protected boolean isforeign = false;

    protected AbstractBankAccount(int acctnum) {
        this.acctnum = acctnum;
    }

    public int getAcctNum() {
        return acctnum;
    }

    public int getBalance() {
        return balance;
    }
    public boolean isForeign() {
        return isforeign;
    }
    public void setForeign(boolean b) {
        isforeign = b;
    }
    public void deposit(int amt) {
        balance += amt;
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
            return getAcctNum() - ba.getAcctNum();  // if bal1 == bal2 but getAcctNum() != ba.getAcctNum() ?
        else
            return bal1 - bal2;

    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof BankAccount)) {
            return false;
        }
        BankAccount ba  = (BankAccount) obj;
        return getAcctNum() == ba.getAcctNum();
    }

    /*
    These methods are declared to be abstract and have
    no associated code. The issue is that AbstractBankAccount implements
    BankAccount, so those methods need to be in its API; however, the class has
    no useful implementation of the methods because the code is provided by
    its subclasses. By declaring those methods to be abstract, the class asserts
    that its subclasses will provide code for them.
     */
    public abstract boolean hasEnoughCollateral(int loanamt);
    public abstract String toString();
    public abstract void addInterest();
}
