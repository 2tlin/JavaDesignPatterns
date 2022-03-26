package version2;

import examples.books.java_programm_design_by_edward_sciore.version2_single_responsibility_rule.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBank {

    @Test
    public void testNewAccount() {
        Bank bank = new Bank();
        BankMock bankMock = new BankMock();
        int accountMock = bankMock.newAccount();
        assertEquals(bank.newAccount(), bankMock.newAccount());
    }
}
