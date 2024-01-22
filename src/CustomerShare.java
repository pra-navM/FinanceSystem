public class CustomerShare {
    private String stockName;
    private String type;
    private int numShares;
    public CustomerShare(String stockName,String type,int numShares){
        this.stockName = stockName;
        this.type = type;
        this.numShares = numShares;
    }
    public String getStockName(){
        return stockName;
    }
    public String getType(){
        return type;

    }
    public int getShares(){
        return numShares;
    }
    public void setShares(int numShares){
        this.numShares=numShares;
    }
    public void setType(String type){
        this.type = type;
    }
    public String toString(){
        return String.format(stockName + " " + type + " " + numShares);
    }
}
