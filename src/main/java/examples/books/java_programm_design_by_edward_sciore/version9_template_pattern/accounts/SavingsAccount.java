package examples.books.java_programm_design_by_edward_sciore.version9_template_pattern.accounts;

public class SavingsAccount extends AbstractBankAccount {

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

    public String accountType() {
        return "Savings";
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected double collateralRatio() {
        return 1. / 2.;
    }
}
