package examples.books.java_programm_design_by_edward_sciore.version7_dont_repear_yourself_rule;

import examples.books.java_programm_design_by_edward_sciore.version7_dont_repear_yourself_rule.accounts.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class BankProgram {
    public static void main(String[] args) {

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(accounts, 0);

        BankClient bankClient = new BankClient(scanner, bank);
        bankClient.run();
    }
}
