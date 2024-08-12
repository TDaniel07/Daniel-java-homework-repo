import java.util.Scanner;

public class Ex5 {
    public static void main(String[] argv){
        double width, length;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("width = ");
        width = inputScanner.nextDouble();

        System.out.println("length = ");
        length = inputScanner.nextDouble();

        System.out.println("area = " + width * length);

        inputScanner.close();
    }
}
