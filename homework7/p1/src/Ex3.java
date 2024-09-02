import java.time.LocalDate;

public class Ex3 {

    public static LocalDate createSpecificDate(){
        return LocalDate.of(2025, 8, 19);
    }

    public static void main(String[] args){
        System.out.println(createSpecificDate());
    }
}
