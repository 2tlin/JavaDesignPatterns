package examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts;

public class RegularChecking extends AbstractCheckingAccount {

    public RegularChecking(int acctnum) {
        super(acctnum);
    }

    public String toString() {
        return "Regular Checking account "
                + acctnum + ": balance="
                + balance + ", is "
                + (isforeign ? "foreign" : "domestic");
    }

    @Override
    public void addInterest() {
        // do nothing
    }
}
