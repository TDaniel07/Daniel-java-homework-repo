package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class YogaWorkout extends Workout {
    public YogaWorkout(LocalDateTime startDateTime, Duration duration){
        super("yoga", startDateTime, duration);
    }

    @Override
    public void printWorkout() {
        System.out.println("type: yoga");
        System.out.println("date: " + getStartDateTime().format(Workout.formatter));
        System.out.println("duration: " + getFormattedDuration());
    }
}
