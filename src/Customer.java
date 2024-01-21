import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable {
    private String name;
    private int ssn;
    private double checkAcc;
    private double savingAcc;
    private double debtAcc;
    private String sharesBought;
    private ArrayList<CustomerShare>shares;
    private ArrayList<String>shareOwned;
    public Customer(String name, int ssn, double checkAcc, double savingAcc,double debtAcc, String sharesBought){
        this.name = name;
        this.ssn = ssn;
        this.checkAcc = checkAcc;
        this.savingAcc = Math.round(savingAcc*100.0)/100.0;
        this.debtAcc = debtAcc;
        this.sharesBought = sharesBought;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ssn, customer.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    public String toString(){
        return name + "(" + ssn + ")";
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
    public double getCheckAcc() {
        return checkAcc;
    }
    public void setCheckAcc(int checkAcc) {
        this.checkAcc = checkAcc;
    }
    // Getter and Setter for savingAcc
    public double getSavingAcc() {
        return savingAcc;
    }

    public void setSavingAcc(int savingAcc) {
        this.savingAcc = savingAcc;
    }

    // Getter and Setter for debtAcc
    public double getDebtAcc() {
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
class CustomComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Customize how objects are displayed in the JComboBox
        if (value instanceof Customer) {
            value = ((Customer) value).toString() ; // Display only the name
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    }
}