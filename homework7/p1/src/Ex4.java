import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex4 {

    public static boolean areDatesEqual(){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Date1(YYYY-MM-DD): ");
        String dateString1 = inputScanner.nextLine();
        System.out.print("\n");

        System.out.print("Date2(YYYY-MM-DD): ");
        String dateString2 = inputScanner.nextLine();
        System.out.print("\n");

        inputScanner.close();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate Date1 = LocalDate.parse(dateString1, formatter);
        LocalDate Date2 = LocalDate.parse(dateString2, formatter);

        return Date1.isEqual(Date2);
    }

    public static void main(String[] args){
        System.out.println(areDatesEqual());
    }
}
