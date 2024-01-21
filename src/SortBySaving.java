import java.util.Comparator;

public class SortBySaving implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare(c2.getSavingAcc(), c1.getSavingAcc());
    }
}
