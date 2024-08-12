import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr1, nr2;

        System.out.println("nr1 = ");
        nr1 = inputScanner.nextInt();

        System.out.println("nr2 = ");
        nr2 = inputScanner.nextInt();

        System.out.println("nr1 + nr2 = " + (nr1 + nr2));
        System.out.println("nr1 - nr2 = " + (nr1 - nr2));
        System.out.println("nr1 * nr2 = " + (nr1 * nr2));
        System.out.println("nr1 / nr2 = " + (nr1 / nr2));
        System.out.println("nr1 % nr2 = " + (nr1 % nr2));
    }
}
