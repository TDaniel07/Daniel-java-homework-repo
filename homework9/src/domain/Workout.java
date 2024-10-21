package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Workout {
    private String type;
    private LocalDateTime startDateTime;
    private Duration duration;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    Workout(String type, LocalDateTime startDateTime, Duration duration){
        this.type = type;
        this.startDateTime = startDateTime;
        this.duration = duration;
    }

    public Duration getDuration(){
        return duration;
    }

    public LocalDateTime getStartDateTime(){
        return startDateTime;
    }

    public String getType(){
        return type;
    }

    public String getFormattedDuration(){
        return duration.toHoursPart() + " hours and " + duration.toMinutesPart() + " minutes";
    }

    public static boolean isValidWorkoutType(String type){
        switch (type){
            case "push ups", "running", "weightlifting", "yoga" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isValidDate(String dateString){
        try {
            LocalDateTime.parse(dateString, formatter);
        }catch (DateTimeParseException error){
            return false;
        }
        return true;
    }

    public static boolean isValidDuration(String durationString){
        String[] parsedDurationString = parseDuration(durationString);
        try{
            Integer.parseInt(parsedDurationString[0]);
            Integer.parseInt(parsedDurationString[1]);
        }catch (NumberFormatException error){
            return false;
        }
        return true;
    }

    public static Duration convertDuration(String durationString){
        String[] parsedDurationString = parseDuration(durationString);
        long hours = Integer.parseInt(parsedDurationString[0]);
        long minutes = Integer.parseInt(parsedDurationString[1]);
        Duration duration = Duration.ofHours(hours);
        duration =  duration.plusMinutes(minutes);

        return duration;
    }

    public static String[] parseDuration(String durationString){
        return durationString.split(":");
    }



    public abstract void printWorkout();
}
