import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice", "Johnson", 20), new Person ("Bob", "Smith", 17));

        List<Person> peopleOver18 = people.stream()
                .filter(person -> person.age >= 18)
                .collect(Collectors.toList());

        System.out.println(peopleOver18);
    }
}
