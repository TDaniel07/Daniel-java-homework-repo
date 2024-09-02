import java.time.LocalDate;

public class Ex1 {

    public static void displayTodaysDate(){
        LocalDate currentDate = LocalDate.now();

        System.out.println(currentDate);
    }

    public static void main(String[] args){
        displayTodaysDate();
    }
}
