import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Customer implements Comparable<Customer>, Serializable{
    private String name;
    private int ssn;
    private double checkAcc;
    private double savingAcc;
    private double debtAcc;
    private double asset;
    private String sharesBought;
    private HashMap<String,CustomerShare>shareMap;
    public Customer(String name, int ssn, double checkAcc, double savingAcc,double debtAcc, String sharesBought){
        shareMap = new HashMap<>();
        this.name = name;
        this.ssn = ssn;
        this.checkAcc = checkAcc;
        this.savingAcc = savingAcc;
        this.debtAcc = debtAcc;
        this.sharesBought = sharesBought;
        StringTokenizer tokenizer = new StringTokenizer(sharesBought);
        while(tokenizer.hasMoreTokens()){
            String stockName = tokenizer.nextToken();
            String stockType = tokenizer.nextToken();
            int stockNum = Integer.parseInt(tokenizer.nextToken());
            CustomerShare newShare = new CustomerShare(stockName,stockType,stockNum);
            shareMap.put(stockName,newShare);
        }
        assetCalc();
    }
    public void assetCalc(){
        asset = checkAcc + savingAcc - debtAcc;
        ListIterator<CustomerShare> iter = (new ArrayList(shareMap.values())).listIterator();
        while(iter.hasNext()){
            CustomerShare share = iter.next();
            if(share.getType().equals("Stock")){
                asset += Main.StockMap.get(share.getStockName()).getNewValue()*share.getShares();

            }
            else asset -= Main.StockMap.get(share.getStockName()).getNewValue()*share.getShares();
        }
        if(asset<0){
            debtAcc-=asset;
            asset=0;
        }
    }
    public void changeShare(int shareNum, String shareName){
        CustomerShare share = shareMap.get(shareName);
        if(shareNum > share.getShares()){
            share.setShares(shareNum-share.getShares());
            if(share.getType().equals("Short")){
                share.setType("Stock");
            }
            else{
                share.setType("Short");
            }
        }
        else{
            share.setShares(share.getShares()-shareNum);
        }
        assetCalc();
    }
    public HashMap getMap(){
        return shareMap;
    }
    public int compareTo(Customer b){
        if(asset > b.getAsset())return 1;
        else if(asset == b.getAsset())return 0;
        return -1;
    }
    public int getSSN() {
        return ssn;
    }
    public String getName(){return name;}

    public double getCheckAcc() {
        return checkAcc;
    }
    public double getSavingAcc() {
        return savingAcc;
    }

    public double getDebtAcc() {
        return debtAcc;
    }
    public String getSharesBought() {
        return sharesBought;
    }
    public double getAsset(){return asset;};
    public void setSSN(int ssn) {
        this.ssn = ssn;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCheckAcc(double checkAcc) {
        this.checkAcc = checkAcc;
        assetCalc();
    }
    public void setSavingAcc(double savingAcc) {
        this.savingAcc = savingAcc;
        assetCalc();
    }
    public void setDebtAcc(double debtAcc) {
        this.debtAcc = debtAcc;
        assetCalc();
    }
    public void setSharesBought(String sharesBought) {
        this.sharesBought = sharesBought;
    }
    public String toString(){
        return name;
    }
    public int hashCode(){
        return Objects.hash(ssn);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ssn, customer.ssn);
    }
}

class CustomComboBoxRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Customize how objects are displayed in the JComboBox
        if (value instanceof Customer) {
            value = ((Customer) value).toString() ; // Display only the name
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    }
}