import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four");

        String concatString = strings.stream()
                .reduce("", (s1, s2) -> s1 + s2 + ',');

        System.out.println(concatString);
    }
}
