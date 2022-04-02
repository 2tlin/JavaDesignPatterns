package examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts;

public class SavingsAccount extends AbstractBankAccount {

    private double rate = 0.01;

    /*
    Note that the constructor calls the method super. The super method
    is a call to the superclass’s constructor and is used primarily when the
    subclass needs the superclass to handle its constructor’s arguments. If a
    subclass’s constructor calls super then Java requires that the call must be
    the first statement of the constructor.
     */
    public SavingsAccount(int acctnum) {
        super(acctnum);
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
