package examples.books.java_programm_design_by_edward_sciore.version8_object_stream;

import examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts.BankAccount;

import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    public static void main(String[] args) {

        SavedBankInfo info = new SavedBankInfo("bank.info");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextacct = info.nextAcctNum();
        Bank bank = new Bank(accounts, nextacct);

        Scanner scanner = new Scanner(System.in);
        BankClient client = new BankClient(scanner, bank);
        client.run();

        info.saveMap(accounts, info.nextAcctNum());
    }
}
