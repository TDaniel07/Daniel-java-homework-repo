import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex12 {

    public static LocalDateTime convertToTimeZone(){
        Scanner inputScanner = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.print("Enter a date (YYYY-MM-DD HH:MM:SS): ");
        String dateString = inputScanner.nextLine();
        System.out.print("\n");

        LocalDateTime date = LocalDateTime.parse(dateString, format);

        System.out.println("Enter a timezone: ");
        String timeZone = inputScanner.nextLine();
        System.out.print("\n");

        ZonedDateTime zonedDate = date.atZone(ZoneId.systemDefault());

        ZonedDateTime convertedDate = zonedDate.withZoneSameInstant(ZoneId.of(timeZone));

        inputScanner.close();

        return convertedDate.toLocalDateTime();

    }

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(convertToTimeZone().format(format));
    }
}
