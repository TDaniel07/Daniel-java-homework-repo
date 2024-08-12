import java.util.Scanner;

public class Ex7 {
    public static void main(String[] argv){
        double weight, height;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("weight (kg) = ");
        weight = inputScanner.nextDouble();

        System.out.println("height (m) = ");
        height = inputScanner.nextDouble();

        System.out.println("BMI index = " + weight / (height * height));

        inputScanner.close();
    }
}
