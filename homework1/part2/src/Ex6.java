import java.util.Scanner;

public class Ex6 {
    public static void main(String[] argv){
        int nr1, nr2, nr3;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("nr1 = ");
        nr1 = inputScanner.nextInt();

        System.out.println("nr2 = ");
        nr2 = inputScanner.nextInt();

        System.out.println("nr3 = ");
        nr3 = inputScanner.nextInt();

        System.out.println("average = " + (nr1 + nr2 + nr3) / 3);

        inputScanner.close();
    }
}
