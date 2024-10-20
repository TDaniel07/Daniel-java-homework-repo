import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = a -> a % 2 == 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 10; i++)
            list.add(i);

        list = filterList(list, isEven);

        System.out.println(list);
    }

    public static List<Integer> filterList(List<Integer> list, Predicate<Integer> condition){
        List<Integer> filteredList = new ArrayList<>();
        for(int element : list){
            if(condition.test(element)){
                filteredList.add(element);
            }
        }
        return filteredList;
    }
}