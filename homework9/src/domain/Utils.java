package domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class Utils {
    public static boolean isInteger(String string){
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException error){
            return false;
        }
    }
    public static LocalDateTime getFirstDayOfWeek(LocalDateTime date){
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
    public static LocalDateTime getLastDayOfWeek(LocalDateTime date){
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    }
}
