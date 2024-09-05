import java.time.LocalDate;

public class Ex8 {

    public static String findDayOfWeek(LocalDate date){

        StringBuilder dayOfWeek = new StringBuilder(date.getDayOfWeek().toString().toLowerCase());

        dayOfWeek.setCharAt(0, Character.toUpperCase(dayOfWeek.charAt(0)));

        return dayOfWeek.toString();
    }

    public static void main(String[] args){
        System.out.println(findDayOfWeek(LocalDate.now()));
    }
}
