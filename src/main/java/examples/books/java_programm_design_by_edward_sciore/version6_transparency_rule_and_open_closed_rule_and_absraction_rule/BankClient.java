package examples.books.java_programm_design_by_edward_sciore.version6_transparency_rule_and_open_closed_rule_and_absraction_rule;

import java.util.Scanner;

/*
The code for BankClient  contains the three global variables from version 1 that are related to input/output, namely
the current account, the scanner, and the am-I-done flag;
it also has an additional variable that holds a reference to the Bank object.
BankClient has the public method run and the private method processCommand; these methods are the same as in version 1.
The code for the individual command methods is similar; the difference is that all bank-specific code
is replaced by a call to the appropriate method of Bank.
 */
public class BankClient {

    private int current = -1;
    private boolean done = false;

    private Scanner scanner;
    private final Bank bank;

    public BankClient(Scanner scanner, Bank bank) { // constructor injection
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.print("Enter command (" +
                    "0 = quit, " +
                    "1 = new, " +
                    "2 = select, " +
                    "3 = deposit, " +
                    "4 = loan, " +
                    "5 = show, " +
                    "6 = interest, " +
                    "7 = setForeign): ");

            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }
    private void processCommand(int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else if (cmd == 7) setForeign();
        else System.out.println("illegal command");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye");
    }

    private void newAccount() {
        boolean isforeign = requestForeign();
        System.out.println("Enter account type: 1 - Saving, 2 - Checking: ");
        int type = scanner.nextInt();
        current = bank.newAccount(type, isforeign);
        System.out.println("Your new account number is " + current);
    }
    private void select() {
        System.out.print("Enter acct#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
    }
    private void deposit() {
        System.out.print("Enter deposit amt: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }
    private void authorizeLoan() {
        System.out.print("Enter loan amt: ");
        int loanamt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanamt))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }
    private void showAll() {
        System.out.println(bank.toString());
    }

    private void addInterest() {
        bank.addInterest();
    }

    private void setForeign() {
        bank.setForeign(current, requestForeign());
    }
    private boolean requestForeign() {
        System.out.print("Enter 1 for foreign, 2 for domestic: ");
        int val = scanner.nextInt();
        return (val == 1);
    }
}
