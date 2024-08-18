import java.util.Scanner;

public class Ex11 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        boolean bool1, bool2;

        System.out.println("first boolean value: ");
        bool1 = inputScanner.nextBoolean();

        System.out.println("second boolean value: ");
        bool2 = inputScanner.nextBoolean();

        bool1 = !bool1;
        bool2 = !bool2;

        System.out.println("first boolean value after negation " + bool1);
        System.out.println("second boolean value after negation " + bool2);
    }
}
