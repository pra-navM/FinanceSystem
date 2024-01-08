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
    }
}
