package examples.books.java_programm_design_by_edward_sciore.version6_transparency_rule_and_open_closed_rule_and_absraction_rule;

public interface BankAccount extends Comparable<BankAccount> {
    int getAcctNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean isforeign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loanamt);
    String toString();
    void addInterest();

    static BankAccount createSavingsWithDeposit(
            int acctnum, int n) {
        BankAccount ba = new SavingsAccount(acctnum);
        ba.deposit(n);
        return ba;
    }
    default boolean isEmpty() {
        return getBalance() == 0;
    }
}
