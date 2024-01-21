import java.util.Comparator;

public class SortByChecking implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare(c2.getCheckAcc(), c1.getCheckAcc());
    }
}
