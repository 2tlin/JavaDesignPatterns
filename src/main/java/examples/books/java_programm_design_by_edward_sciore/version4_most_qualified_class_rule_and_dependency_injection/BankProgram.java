package examples.books.java_programm_design_by_edward_sciore.version4_most_qualified_class_rule_and_dependency_injection;

public class BankProgram {
    public static void main(String[] args) {
        BankClient bankClient = new BankClient();
        bankClient.run();
    }
}
