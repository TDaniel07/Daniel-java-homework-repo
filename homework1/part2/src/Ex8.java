import java.util.Scanner;

public class Ex8 {
    public static void main(String[] argv){
        double radius;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("radius = ");
        radius = inputScanner.nextDouble();

        System.out.println("area = " + 3.14 * (radius * radius));
        System.out.println("circumference = " + 2 * 3.14 * radius);

        inputScanner.close();
    }
}
