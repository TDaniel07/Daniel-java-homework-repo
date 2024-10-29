import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex7 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World", "Java", "Streams");

        List<Integer> stringsLengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(stringsLengths);
    }
}
