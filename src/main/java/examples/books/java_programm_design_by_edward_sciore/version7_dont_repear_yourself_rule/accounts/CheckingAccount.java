package examples.books.java_programm_design_by_edward_sciore.version7_dont_repear_yourself_rule.accounts;

public class CheckingAccount extends AbstractBankAccount {

    public CheckingAccount(int acctnum) {
        super(acctnum);
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

    @Override
    public void addInterest() {
        // do nothing
    }
}
