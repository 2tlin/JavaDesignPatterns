package examples.books.java_programm_design_by_edward_sciore.version9_template_pattern.accounts;

public class RegularChecking extends AbstractCheckingAccount {

    public RegularChecking(int acctnum) {
        super(acctnum);
    }

    protected String accountType() {
        return "Regular Checking";
    }
    protected double interestRate() {
        return 0.0;
    }
}
