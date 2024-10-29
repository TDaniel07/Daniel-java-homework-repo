import java.util.Comparator;
import java.util.Map;

public class ItemComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> shoppingCart1, Map.Entry<String, Integer> shoppingCart2){
        return shoppingCart1.getValue().compareTo(shoppingCart2.getValue());
    }
}
