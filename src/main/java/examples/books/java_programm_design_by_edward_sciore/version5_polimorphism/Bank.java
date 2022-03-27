package examples.books.java_programm_design_by_edward_sciore.version5_polimorphism;

import java.util.HashMap;

/*
The code for Bank contains the three variables of version 1 that are relevant to the bank, namely the map of accounts,
the interest rate, and the value of the next account number.
The six methods in its API corresponds to the command methods of version 1 (except for quit).

Their code consists of the code of those methods, with the input/output code stripped out.
For example, the code for the newAccount method adds a new account to the map but does not print its information to the console.
Instead, it returns the account number to BankClient, which is responsible for printing the information.

Similarly, the deposit method is not responsible for asking the user for the deposit amount. Instead,
it expects the caller of the method (i.e., BankClient) to pass the amount as an argument.
The authorizeLoan method eliminates both input and output code from the corresponding version 1 method.
It expects the loan amount to be passed in as an argument and it returns the decision as a boolean.
The getBalance method corresponds to the select method of version 1.
That method is primarily concerned with choosing a current account, which is the responsibility of BankClient.
Its only bank-specific code involves obtaining the balance of the selected account. The Bank class
therefore has a getBalance method for select to call.

 */
public class Bank {
    private int nextacct;
    private HashMap<Integer, BankAccount> accounts;

    private double rate = 0.01;


    public Bank(HashMap<Integer, BankAccount> accounts, int nextacct) { // constructor injection
        this.accounts = accounts;
        this.nextacct = nextacct;
    }

    public int newAccount(int type, boolean isforeign) {
        int acctnum = nextacct++;
        // use polymorphism
        BankAccount ba;
        if (type == 1)
            ba = new SavingsAccount(acctnum);
        else
            ba = new CheckingAccount(acctnum);
        ba.setForeign(isforeign);
        accounts.put(acctnum, ba);
        return acctnum;
    }

    public int getBalance(int acctnum) {
        BankAccount ba = accounts.get(acctnum);
        return ba.getBalance();
    }

    public void deposit(int acctnum, int amt) {
        BankAccount ba = accounts.get(acctnum);
        ba.deposit(amt);
    }

    public void setForeign(int acctnum, boolean isforeign) {
        BankAccount ba = accounts.get(acctnum);
        ba.setForeign(isforeign);
    }

    public boolean authorizeLoan(int acctnum,
                                 int loanamt) {
        BankAccount ba = accounts.get(acctnum);
        return ba.hasEnoughCollateral(loanamt);
    }

    public String toString() {
        String result = "The bank has " + accounts.size()
                + " accounts.";
        for (BankAccount ba : accounts.values())
            result += "\n\t" + ba.toString();
        return result;
    }

    public void addInterest() {
        for (BankAccount ba : accounts.values())
            if (ba instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) ba;
                sa.addInterest();
            }
    }
}