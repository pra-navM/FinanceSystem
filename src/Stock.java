import java.util.*;
public class Stock {
    private String name;
    private ArrayList<Double>value;
    private int cap;
    private int currentShares = 0;
    private int currentShorts = 0;
    public Stock (String name, double value, int cap){
        this.name = name;
        this.value = new ArrayList<>();
        this.value.add(value);
        this.cap = cap;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getValue() {
        return value;
    }
    public Double getNewValue(){
        return value.getLast();
    }

    public int getCap() {
        return cap;
    }

    public void setValue(double value){
        this.value.add(value);
    }
    public void setCap(int cap) {
        this.cap = cap;
    }
    public int getCurrentShares(){
        return currentShares;
    }
    public int getCurrentShorts(){
        return currentShorts;
    }
    public void addStock(int shares){
        currentShares+=shares;
    }
    public void addShort(int shorts){
        currentShorts+=shorts;
    }
}
