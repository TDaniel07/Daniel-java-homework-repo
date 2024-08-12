import java.util.Scanner;

public class Ex4 {
    public static void main(String[] argv){
        int nr1, nr2;

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("first number = ");
        nr1 = inputScanner.nextInt();

        System.out.println("second number = ");
        nr2 = inputScanner.nextInt();

        System.out.println("sum = " + (nr1 + nr2));

        inputScanner.close();
    }
}
