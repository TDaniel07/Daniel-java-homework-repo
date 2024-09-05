import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String binaryNumber;

        System.out.print("Enter a binary number: ");
        binaryNumber = inputScanner.nextLine();
        System.out.println();

        System.out.println("Decimal number: " + Integer.parseInt(binaryNumber, 2));
    }
}
