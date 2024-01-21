import java.util.Comparator;

public class SortByName implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return c1.getName().compareTo(c2.getName());
    }
}
