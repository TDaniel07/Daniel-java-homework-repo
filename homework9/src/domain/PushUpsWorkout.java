package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class PushUpsWorkout extends Workout{
    private int reps;

    public PushUpsWorkout(LocalDateTime startDateTime, Duration duration, int reps){
        super("push ups", startDateTime, duration);
        this.reps = reps;
    }

    public int getReps(){
        return reps;
    }

    public void addReps(int reps){
        this.reps += reps;
    }

    public void setReps(int reps){
        this.reps = reps;
    }

    @Override
    public void printWorkout() {
        System.out.println("type: " + getType());
        System.out.println("date: " + getStartDateTime().format(Workout.formatter));
        System.out.println("duration: " + getFormattedDuration());
        System.out.println("reps: " + reps);
    }
}
