import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ex3 {
    public static void main(String[] args) {
        //Nu mi-am dat seama cum altcumva sa rezolv acest exercitiu decat folosind un lambda expresion pe mai multe linii. Functia este usor de inteles asa ca ma gandesc ca nu este bad practice.
        Function<List<Integer>, Integer> listSum = list -> {
            int result = 0;
            for(int element : list)
                result += element;
            return result;
        };

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 20; i++)
            list.add(i);

        System.out.println(listSum.apply(list));
    }
}
