import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 7, 8, 12, 15);

        System.out.println(numbers);

        numbers = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());


        System.out.println(numbers);
    }
}