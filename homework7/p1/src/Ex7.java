import java.time.LocalDate;

public class Ex7 {

    public static LocalDate addWeeksToToday(int weeks){
        LocalDate currentDate = LocalDate.now();

        return currentDate.plusWeeks(weeks);
    }

    public static void main(String[] args){
        System.out.println(addWeeksToToday(10));
    }
}
