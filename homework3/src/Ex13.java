import java.util.Scanner;

public class Ex13 {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        float price, discount;

        System.out.println("price = ");
        price = inputScanner.nextFloat();

        System.out.println("discount = ");
        discount = inputScanner.nextFloat();

        price -= price * (discount / 100);

        System.out.println("price after discount = " + price);
    }
}
