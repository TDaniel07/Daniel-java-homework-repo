package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class WeightliftingWorkout extends Workout{
    private int weight; //measured in Kg
    private int reps;

    public WeightliftingWorkout(LocalDateTime startDateTime, Duration duration, int weightInKg, int reps){
        super("weightlifting", startDateTime, duration);
        weight = weightInKg;
        this.reps = reps;
    }

    public int getWeight(){
        return weight;
    }

    public int getReps(){
        return reps;
    }

    public void addWeight(int weightInKg){
        weight += weightInKg;
    }

    public void addReps(int reps){
        this.reps += reps;
    }

    public void setWeight(int weightInKg){
        weight = weightInKg;
    }

    public void setReps(int reps){
        this.reps = reps;
    }

    @Override
    public void printWorkout() {
        System.out.println("type: " + getType());
        System.out.println("date: " + getStartDateTime().format(Workout.formatter));
        System.out.println("duration: " + getFormattedDuration());
        System.out.println("weight: " + weight + " kg");
        System.out.println("reps: " + reps);
    }
}
