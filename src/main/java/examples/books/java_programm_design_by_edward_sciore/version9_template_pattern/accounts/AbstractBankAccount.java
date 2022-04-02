package examples.books.java_programm_design_by_edward_sciore.version9_template_pattern.accounts;

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

    // template methods
    public String toString() {
        String accttype = accountType();
        return accttype + " account " + acctnum
                + ": balance=" + balance + ", is "
                + (isforeign ? "foreign" : "domestic");
    }

    public void addInterest() {
        balance += (int) (balance * interestRate());
    }

    /*
    That is, the hasEnoughCollateral method is no longer abstract.
    Instead, it is a template that calls the abstract helper method
    collateralRatio, whose code is implemented by the subclasses.
     */
    public boolean hasEnoughCollateral(int loanamt) {
        double ratio = collateralRatio();
        return balance >= loanamt * ratio;
    }

    // abstract helper methods are sometimes called “hooks.”
    protected abstract String accountType();
    protected abstract double interestRate();
    protected abstract double collateralRatio();
    ;
}
