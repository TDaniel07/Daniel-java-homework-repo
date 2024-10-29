import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","d","e"));
        swap(list, 2, 3);
        System.out.println(list);

    }

    public static <T> void swap(List<T> array, int pos1, int pos2){
        T element1 = array.get(pos1);
        T element2 = array.get(pos2);

        array.set(pos1, element2);
        array.set(pos2, element1);
    }
}
