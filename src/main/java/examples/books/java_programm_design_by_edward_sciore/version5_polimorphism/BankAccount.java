package examples.books.java_programm_design_by_edward_sciore.version5_polimorphism;

public interface BankAccount {
    int getAcctNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean isforeign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loanamt);
    String toString();
}
