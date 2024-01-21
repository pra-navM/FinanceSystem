import java.util.Comparator;

public class SortByDebt implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare(c2.getDebtAcc(), c1.getDebtAcc());
    }
}