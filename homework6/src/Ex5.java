import java.util.Scanner;

public class Ex5 {

    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        int[] s1CharFrequency = new int[123]; //puteam folosi un hashmap dar avand in vedere ca sunt cuvinte overhead-ul pentru declararea unui hashmap ar fi fost prea mare
        StringBuilder s1Chars = new StringBuilder(); //folosesc acest string pentru a evita verificarea tuturor literelor chiar daca sunt in niciunul dintre string-uri

        for(int i = 0; i < s1.length(); i++){
            if(s1CharFrequency[s1.charAt(i)] == 0)
                s1Chars.append(s1.charAt(i));
            s1CharFrequency[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++){
            s1CharFrequency[s2.charAt(i)]--;

            if(s1CharFrequency[s2.charAt(i)] < 0)
                return false;
        }

        for(int i = 0; i < s1Chars.length(); i++){
            if(s1CharFrequency[s1Chars.charAt(i)] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String word1 = inputScanner.nextLine();
        System.out.print('\n');

        System.out.print("Enter second word: ");
        String word2 = inputScanner.nextLine();
        System.out.print('\n');

        System.out.println(isAnagram(word1, word2));
    }
}
