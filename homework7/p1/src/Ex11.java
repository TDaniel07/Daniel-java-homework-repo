import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex11 {

    public static LocalTime elapsedTimeSince(String priorTimeString){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime priorTime = LocalTime.parse(priorTimeString, format);
        LocalTime currentTime = LocalTime.now();


        Duration duration = Duration.between(priorTime, currentTime);

        int hours = duration.toHoursPart();
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();


        return LocalTime.of(hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a past time (HH:MM:SS): ");
        String inputTime = inputScanner.nextLine();

        System.out.println(elapsedTimeSince(inputTime));
    }
}
