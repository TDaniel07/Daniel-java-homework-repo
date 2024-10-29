import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 100)
                .boxed()
                .filter(Ex3::prime)
                .collect(Collectors.toList());

        System.out.println(numbers);
    }

    public static boolean prime(int number){
        if(number <= 1)
            return false;
        if(number == 2)
            return true;
        if(number % 2 == 0)
            return false;

        for(int i = 3; i * i <= Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }

        return true;
    }
}
