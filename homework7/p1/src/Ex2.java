import java.time.LocalDate;

public class Ex2 {
    public static void displayDateComponents(LocalDate date){
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonthValue());
        System.out.println("Day: " + date.getDayOfMonth());
    }

    public static void main(String[] args){
        LocalDate currentDate = LocalDate.now();
        displayDateComponents(currentDate);
    }
}
