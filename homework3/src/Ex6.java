import java.util.Scanner;

public class Ex6 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr1, nr2;

        System.out.println("nr1 = ");
        nr1 = inputScanner.nextInt();

        System.out.println("nr2 = ");
        nr2 = inputScanner.nextInt();

        if(nr1 > nr2)
            System.out.println("nr1 is greater than nr2");
        else if(nr1 == nr2)
            System.out.println("nr1 is equal to nr2");
        else
            System.out.println("nr1 is less than nr2");
    }
}
