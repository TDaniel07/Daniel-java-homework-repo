import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        MaximumValue maximumValue = list ->{
            int maxValue = 0;
            for(int element : list){
                if(element > maxValue)
                    maxValue = element;
            }
            return maxValue;
        };

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= 10; i++){
            list.add(random.nextInt(100));
        }

        System.out.println(list);

        System.out.println(maximumValue.get(list));
    }
}
