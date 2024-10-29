import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};

        int sumOfNumbers = Arrays.stream(numbers)
                .reduce(0, Integer::sum);

        System.out.println(sumOfNumbers);
    }
}
