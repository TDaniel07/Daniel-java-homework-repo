import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr;

        System.out.println("nr = ");
        nr = inputScanner.nextInt();

        if(!(nr >= 0)){
            System.out.println("nr is negative");
        }
        else
            System.out.println("nr is positive");
    }
}
