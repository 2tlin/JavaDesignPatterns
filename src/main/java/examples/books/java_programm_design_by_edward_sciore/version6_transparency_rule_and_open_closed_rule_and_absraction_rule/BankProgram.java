package examples.books.java_programm_design_by_edward_sciore.version6_transparency_rule_and_open_closed_rule_and_absraction_rule;

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
