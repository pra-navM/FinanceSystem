import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Customer {
    private String name;
    private int ssn;
    private int checkAcc;
    private int savingAcc;
    private int debtAcc;
    private ArrayList<CustomerShare>shares;
    private ArrayList<String>shareOwned;
    public Customer(String name, int ssn, int checkAcc, int savingAcc,int debtAcc){
        this.name = name;
        this.ssn = ssn;
        this.checkAcc = checkAcc;
        this.savingAcc = savingAcc;
        this.debtAcc = debtAcc;
        //save to file
        try {
            PrintWriter outFile = new PrintWriter (new FileWriter("customerSave.txt"));
            outFile.println(name);
            outFile.println(ssn);
            outFile.println(checkAcc);
            outFile.println(savingAcc);
            outFile.println(debtAcc);
            outFile.close();
        }
        catch (IOException e) {
            System.out.println ("Writing error");
        }
    }
}
