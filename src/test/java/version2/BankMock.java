package version2;

import java.util.HashMap;
import java.util.Set;

public class BankMock {
    private HashMap<Integer,Integer> accountsMock = new HashMap<>();

    public int newAccount() {

        System.out.println("newAccount called, returning 0");
        return 0;
    }
    public int getBalance(int acctnum) {
        System.out.println("getBalance(" + acctnum + ") called, returning 50");
        return 50;
    }

    public void deposit(int acctnum, int amt) {
        System.out.println("deposit(" + acctnum + ", "
                + amt + ") called");
    }

    public boolean authorizeLoan(int acctnum,
                                 int loanamt) {
        System.out.println("authorizeLoan(" + acctnum
                + ", " + loanamt
                + ") called, returning true");
        return true;
    }
}
