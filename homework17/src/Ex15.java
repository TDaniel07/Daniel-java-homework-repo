import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex15 {
    public static void main(String[] args) {
        ListFilter<String> stringFilter = (list, predicate) ->  {
            List<String> filteredList = new ArrayList<>();
            for(String element : list){
                if(predicate.test(element))
                    filteredList.add(element);
            }
            return filteredList;
        };

        List<String> list = generateRandomList(20);

        System.out.println(list);

        list = stringFilter.filter(list, (e) -> e.length() <= 4);

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
