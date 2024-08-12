import java.util.Scanner;

public class Ex8 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        byte nr1, nr2, result;

        System.out.println("nr1 = ");
        nr1 = inputScanner.nextByte();

        System.out.println("nr2 = ");
        nr2 = inputScanner.nextByte();

        result = (byte) (nr1 + nr2);

        System.out.println("result = " + result);
    }
}
