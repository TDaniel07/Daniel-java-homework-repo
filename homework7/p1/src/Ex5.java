import java.time.LocalDate;

public class Ex5 {

    public static boolean isTodaySpecificDate(){
        LocalDate currentDate = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2019, 12, 10);

        return currentDate.equals(specificDate);
    }

    public static void main(String[] args){
        System.out.println(isTodaySpecificDate());
    }
}
