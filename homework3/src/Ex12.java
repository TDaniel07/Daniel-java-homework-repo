import java.util.Scanner;

public class Ex12 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr;

        System.out.println("nr = ");
        nr = inputScanner.nextInt();

        nr++;
        System.out.println("nr++ = " + nr);

        nr--;
        System.out.println("nr-- = " + nr);
    }
}
