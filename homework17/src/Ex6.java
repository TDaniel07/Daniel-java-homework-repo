import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex6 {
    public static void main(String[] args) {
        StringComparator comparator = (s1, s2) -> Integer.max(s1.length(), s2.length());

        System.out.println(comparator.compare("abc", "abcde"));
    }

}
