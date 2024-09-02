import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex6 {

    public static void displayCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(currentTime.format(format));
    }

    public static void main(String[] args){
        displayCurrentTime();
    }
}
