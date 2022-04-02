package examples.books.java_programm_design_by_edward_sciore.version9_template_pattern.accounts;

public abstract class AbstractCheckingAccount extends AbstractBankAccount {

    // constructor is protected because it should be called only by subclasses
    protected AbstractCheckingAccount(int acctnum) {
        super(acctnum);
    }

    protected abstract double interestRate();
    protected abstract String accountType();

    @Override
    protected double collateralRatio() {
        return 2. / 3.;
    }
}
