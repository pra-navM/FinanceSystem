import java.util.Comparator;
// Class to sort by assets.
public class SortByNetAsset implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare(c2.getAsset(),c1.getAsset());
    }

}
