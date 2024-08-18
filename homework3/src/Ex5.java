import java.util.Scanner;

public class Ex5 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int nr;

        System.out.println("nr = ");
        nr = inputScanner.nextInt();

        nr += 2;
        System.out.println("nr = " + nr);

        nr -= 5;
        System.out.println("nr = " + nr);

        nr /= 2;
        System.out.println("nr = " + nr);

        nr *= 2;
        System.out.println("nr = " + nr);

        nr %= 5;
        System.out.println("nr = " + nr);

        nr <<= 1;
        System.out.println("nr = " + nr);

        nr >>= 1;
        System.out.println("nr = " + nr);

        nr &= 8;
        System.out.println("nr = " + nr);

        nr |= 32;
        System.out.println("nr = " + nr);

        nr ^= 128;
        System.out.println("nr = " + nr);

        nr >>>= 1;
        System.out.println("nr = " + nr);
    }
}
