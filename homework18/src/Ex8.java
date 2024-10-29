import java.util.stream.Stream;

public class Ex8 {
    public static void main(String[] args) {
        String sentence = "Hello world";

        int numberOfVowels = sentence.chars()
                        .mapToObj((c) -> (char)c)
                                .reduce(0, (count, c) -> isVowel(c) ? count + 1 : count);


        System.out.println(numberOfVowels);
    }


    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
