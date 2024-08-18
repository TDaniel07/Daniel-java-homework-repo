import java.util.Scanner;

public class Ex9 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int length, breadth;

        System.out.println("length = ");
        length = inputScanner.nextInt();

        System.out.println("breadth = ");
        breadth = inputScanner.nextInt();

        System.out.println("area = " + (length * breadth));
    }
}
