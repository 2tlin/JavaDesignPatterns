package examples.books.java_programm_design_by_edward_sciore.version9_template_pattern.accounts;

public class InterestChecking extends AbstractCheckingAccount {

    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    public String accountType() {
        return "Interest Checking";
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    public void addInterest() {
        int newbalance = (int) (getBalance() * interestRate());
        deposit(newbalance);
    }


}
