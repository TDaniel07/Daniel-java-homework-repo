import java.time.LocalDate;

public class Ex9 {
    public static long daysBetween(LocalDate date1, LocalDate date2) {
        long absoluteDate1 = date1.toEpochDay();
        long absoluteDate2 = date2.toEpochDay();

        return absoluteDate1 > absoluteDate2 ? absoluteDate1 - absoluteDate2 : absoluteDate2 - absoluteDate1;
    }

    public static void main(String[] args) {
        System.out.println(daysBetween(LocalDate.now(), LocalDate.now().plusYears(2)));
    }
}
