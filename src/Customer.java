import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable {
    private String name;
    private int ssn;
    private int checkAcc;
    private int savingAcc;
    private int debtAcc;
    private String sharesBought;
    private ArrayList<CustomerShare>shares;
    private ArrayList<String>shareOwned;
    public Customer(String name, int ssn, int checkAcc, int savingAcc,int debtAcc, String sharesBought){
        this.name = name;
        this.ssn = ssn;
        this.checkAcc = checkAcc;
        this.savingAcc = savingAcc;
        this.debtAcc = debtAcc;
        this.sharesBought = sharesBought;
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for ssn
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    // Getter and Setter for checkAcc
    public int getCheckAcc() {
        return checkAcc;
    }

    public void setCheckAcc(int checkAcc) {
        this.checkAcc = checkAcc;
    }

    // Getter and Setter for savingAcc
    public int getSavingAcc() {
        return savingAcc;
    }

    public void setSavingAcc(int savingAcc) {
        this.savingAcc = savingAcc;
    }

    // Getter and Setter for debtAcc
    public int getDebtAcc() {
        return debtAcc;
    }

    public void setDebtAcc(int debtAcc) {
        this.debtAcc = debtAcc;
    }

    // Getter and Setter for sharesBought
    public String getSharesBought() {
        return sharesBought;
    }

    public void setSharesBought(String sharesBought) {
        this.sharesBought = sharesBought;
    }

}
