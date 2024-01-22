import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Customer implements Serializable{
    private String name;
    private int ssn;
    private double checkAcc;
    private double savingAcc;
    private double debtAcc;
    private double asset;
    private HashMap<String,CustomerShare>shareMap;
    public Customer(String name, int ssn, double checkAcc, double savingAcc,double debtAcc, String sharesBought){
        shareMap = new HashMap<>();
        this.name = name;
        this.ssn = ssn;
        this.checkAcc = checkAcc;
        this.savingAcc = savingAcc;
        this.debtAcc = debtAcc;
        if(!sharesBought.isBlank()){
            StringTokenizer tokenizer = new StringTokenizer(sharesBought);
            while(tokenizer.hasMoreTokens()){
                String stockName = tokenizer.nextToken();
                String stockType = tokenizer.nextToken();
                int stockNum = Integer.parseInt(tokenizer.nextToken());
                CustomerShare newShare = new CustomerShare(stockName,stockType,stockNum);
                shareMap.put(stockName,newShare);
            }
        }
        assetCalc();
    }
    public void assetCalc(){
        asset = checkAcc + savingAcc - debtAcc;
        if(!shareMap.isEmpty()){
            ListIterator<CustomerShare> iter = (new ArrayList(shareMap.values())).listIterator();
            while(iter.hasNext()){
                CustomerShare share = iter.next();
                if(share.getType().equals("Stock")){
                    asset += Main.StockMap.get(share.getStockName()).getNewValue()*share.getShares();

                }
                else asset -= Main.StockMap.get(share.getStockName()).getNewValue()*share.getShares();
            }
        }
        if(asset<0){
            debtAcc-=asset;
            asset=0;
        }
    }
    public void changeShare(int shareNum, String shareName){
        Stock stock = Main.StockMap.get(shareName);
        if(shareMap.containsKey(shareName)) {
            CustomerShare share = shareMap.get(shareName);
            if (-shareNum > share.getShares()) {
                if (share.getType().equals("Short")) {
                    stock.addShort(-share.getShares());
                    stock.addStock(shareNum - share.getShares());
                    share.setType("Stock");
                } else {
                    stock.addStock(-share.getShares());
                    stock.addShort(shareNum - share.getShares());
                    share.setType("Short");
                }
                share.setShares(shareNum - share.getShares());
            } else {
                share.setShares(share.getShares() + shareNum);
                if (share.getType().equals("Short")) {
                    stock.addShort(shareNum);
                } else {
                    stock.addStock(shareNum);
                }
            }
        }
        else{
            shareMap.put(shareName,new CustomerShare(shareName,"Stock",shareNum));
        }
        assetCalc();
    }
    public int getSSN(){return ssn;}
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
        String sharesBought = "";
        for(CustomerShare share:shareMap.values()){
            sharesBought+=String.format("%-23s%-9s%-11s$%-10s$%s%n",share.getStockName(),share.getType(),share.getShares(),(Main.StockMap.get(share.getStockName())).getNewValue(),(Main.StockMap.get(share.getStockName())).getNewValue()*share.getShares());
        }
        return sharesBought;
    }
    public double getAsset(){return asset;}
    public HashMap getMap(){return shareMap;}
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