import java.util.Comparator;
// Class to sort by debt.
public class SortByDebt implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare(c2.getDebtAcc(), c1.getDebtAcc());
    }
}