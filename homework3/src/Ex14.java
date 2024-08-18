import java.util.Scanner;

public class Ex14 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr;

        System.out.println("nr = ");
        nr = inputScanner.nextInt();

        if(nr >= 1 && nr <= 100)
            System.out.println("nr is within [1-100]");
        else
            System.out.println("nr is outside [1-100]");
    }
}
