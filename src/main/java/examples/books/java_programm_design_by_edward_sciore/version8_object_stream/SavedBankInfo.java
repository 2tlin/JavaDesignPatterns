package examples.books.java_programm_design_by_edward_sciore.version8_object_stream;

import examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts.BankAccount;
import examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts.InterestChecking;
import examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts.RegularChecking;
import examples.books.java_programm_design_by_edward_sciore.version8_object_stream.accounts.SavingsAccount;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/*
The variables accounts and nextaccount are initialized for a bank having no accounts.
The constructor is responsible for reading the specified file; if the file exists,
it calls the local method readMap to use the saved account information
to initialize nextaccount and populate the map. The method saveMap
opens an output stream for the file and calls writeMap to write the account
information to that stream.
 */

public class SavedBankInfo {
    private String fileName;
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    String dirPath = "C:\\Users\\DVatlin\\IdeaProjects\\JavaDesignPatternsGOF\\src\\main\\java\\examples\\books\\java_programm_design_by_edward_sciore\\version8_object_stream\\";

    private int nextAccount = 0;
    /*
    SavedBankInfo has a variable of type ByteBuffer.
    The ByteBuffer class defines methods for converting between values and bytes.
    A ByteBuffer object has an underlying byte array.
    Its method putInt stores the 4-byte representation of an integer into the array at the specified offset;
    its method getInt converts the 4 bytes at the specified offset into an integer.

    SavedBankInfo creates a single 16-byte ByteBuffer object, whose underlying array will be used
    for all reading and writing to the file.
     */
    private ByteBuffer byteBuffer = ByteBuffer.allocate(16);

    public SavedBankInfo(String fileName) {
        this.fileName = fileName;
        /*
        if the file exists, it calls the local method readMap to use the saved account information
        to initialize nextaccount and populate the map.
         */
        if (new File(dirPath + fileName).exists()) {
            try (InputStream inputStream = new FileInputStream(dirPath + fileName)) {
                readMap(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("File read exception");
            }
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int nextAcctNum() {
        return nextAccount;
    }

    public void saveMap(Map<Integer, BankAccount> map, int nextAccount) {
        try(OutputStream outputStream = new FileOutputStream(fileName)) {
            writeMap(outputStream, map, nextAccount);
        } catch (IOException e) {
            throw new RuntimeException("File write exception");
        }
    }



    /*
    These methods determine the overall structure of the data file. First,
    writeMap writes an integer denoting the next account number; then it writes
    the values for each account. The readMap method reads these values back.
    It first reads an integer and saves it in the global variable nextaccount. Then
    it reads the account information, saving each account in the map.
     */

    private void writeMap(OutputStream outputStream,
                          Map<Integer, BankAccount> map,
                          int nextAccount) throws IOException {

        writeInt(outputStream, nextAccount);
        for (BankAccount ba: map.values())
            writeAccount(outputStream, ba);
    }

    private void readMap(InputStream inputStream) throws IOException {
        nextAccount = readInt(inputStream);
        BankAccount ba = readAccount(inputStream);
        while (ba != null) {
            accounts.put(ba.getAcctNum(), ba);
            ba = readAccount(inputStream);
        }
    }

    /*
    The writeInt method stores an integer in the first four bytes of the byte
    buffer’s underlying array, and then uses the 3-argument write method
    to write those bytes to the output stream. The readInt method uses the
    3-argument read method to read four bytes into the beginning of the
    ByteBuffer array, and then converts those bytes to an integer.
     */

    private void writeInt (OutputStream outputStream, int nextAccount) throws IOException {
        byteBuffer.putInt(0, nextAccount);
        outputStream.write(byteBuffer.array(), 0, 4);
    }

    private int readInt(InputStream inputStream) throws IOException {
        inputStream.read(byteBuffer.array(), 0, 4);
        return byteBuffer.getInt(0);
    }

    /*
    The writeAccount method extracts the four crucial values from a bank
    account (its account number, type, balance, and isforeign flag), converts
    them to four integers, places them into the byte buffer, and then writes
    the entire underlying byte array to the output stream. The readAccount
    method reads 16 bytes into the underlying byte array and converts it into
    four integers. It then uses these integers to create a new account and
    configure it properly. The method indicates end of stream by returning a
    null value.
     */

    private void writeAccount(OutputStream outputStream, BankAccount ba) throws IOException {
        int type =  (ba instanceof SavingsAccount) ? 1 : (
                    (ba instanceof RegularChecking) ? 2 : 3
        );
        byteBuffer.putInt(0, ba.getAcctNum());
        byteBuffer.putInt(4, type);
        byteBuffer.putInt(8, ba.getBalance());
        byteBuffer.putInt(12, ba.isForeign() ? 1 : 2);

        outputStream.write(byteBuffer.array());
    }

    private BankAccount readAccount(InputStream inputStream) throws IOException {

        int n = inputStream.read(byteBuffer.array());
        if (n < 0) return null;

        int num = byteBuffer.getInt(0);
        int type = byteBuffer.getInt(4);
        int balance = byteBuffer.getInt(8);
        int isforeign = byteBuffer.getInt(12);

        BankAccount ba;
        if (type == 1)
            ba = new SavingsAccount(num);
        else if (type == 2)
            ba = new RegularChecking(num);
        else
            ba = new InterestChecking(num);
        ba.deposit(balance);
        ba.setForeign(isforeign == 1);
        return ba;
    }
}
