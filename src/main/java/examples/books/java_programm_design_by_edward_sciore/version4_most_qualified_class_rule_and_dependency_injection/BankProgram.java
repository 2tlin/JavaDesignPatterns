package examples.books.java_programm_design_by_edward_sciore.version4_most_qualified_class_rule_and_dependency_injection;

import java.util.HashMap;
import java.util.Map;
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
