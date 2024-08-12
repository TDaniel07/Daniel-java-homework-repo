import java.util.Scanner;

public class Ex9 {
    public static void main(String[] argv){
        double celsius;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("temperature in celsius = ");
        celsius = inputScanner.nextDouble();

        System.out.println("temperature in fahrenheit = " + (celsius * (9.0 / 5) + 32));

        inputScanner.close();
    }
}
