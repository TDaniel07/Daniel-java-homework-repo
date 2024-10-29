import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String longestString = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println(longestString);
    }
}
