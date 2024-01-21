import java.util.Comparator;

public class SortByNetAsset implements Comparator<Customer> {
    public int compare (Customer c1, Customer c2){
        return Double.compare((c2.getCheckAcc() + c2.getSavingAcc()) - c2.getDebtAcc(),
                (c1.getCheckAcc() + c1.getSavingAcc() - c1.getDebtAcc()));
    }

}
