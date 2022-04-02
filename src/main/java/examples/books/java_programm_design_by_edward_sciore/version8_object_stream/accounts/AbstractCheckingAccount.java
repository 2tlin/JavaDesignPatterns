package examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts;

public abstract class AbstractCheckingAccount extends AbstractBankAccount {

    // constructor is protected because it should be called only by subclasses
    protected AbstractCheckingAccount(int acctnum) {
        super(acctnum);
    }

    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= 2 * loanamt / 3;
    }

    public abstract String toString();
    public abstract void addInterest();
}
