import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex2 {
    public static void main(String[] args) {
        List<String> list = generateRandomList(10);

        System.out.println(list);

        list.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println(list);
    }

    public static List<String> generateRandomList(int numberOfElements){
        Random random = new Random();
        List<String> randomList = new ArrayList<>();

        for(int i = 1; i <= numberOfElements; i++){
            StringBuilder randomString = new StringBuilder();
            int randomStringLength = random.nextInt(10) + 1;

            for(int j = 1; j <= randomStringLength; j++){
                char randomChar = (char)(random.nextInt(26) + 97);
                randomString.append(randomChar);
            }
            randomList.add(randomString.toString());
        }

        return randomList;
    }
}
