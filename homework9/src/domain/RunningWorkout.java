package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class RunningWorkout extends Workout{
    private Distance runningDistance;

    public RunningWorkout(LocalDateTime startDateTime, Duration duration, Distance runningDistance) {
        super("running", startDateTime, duration);
        this.runningDistance = runningDistance;
    }

    public Distance getDistance(){
        return runningDistance;
    }

    public int getDistanceInTotalMeters(){
        return runningDistance.getTotalMeters();
    }

    public int getDistanceInMeters(){
        return runningDistance.getMeters();
    }

    public int getDistanceInKilometers(){
        return runningDistance.getKilometers();
    }

    public void addMeters(int meters){
        runningDistance.addMeters(meters);
    }

    public void addKilometers(int kilometers){
        runningDistance.addKilometers(kilometers);
    }

    public void setTotalMeters(int totalMeters){
        runningDistance.setMeters(totalMeters);
    }

    @Override
    public void printWorkout() {
        System.out.println("type: " + getType());
        System.out.println("date: " + getStartDateTime().format(Workout.formatter));
        System.out.println("duration: " + getFormattedDuration());
        System.out.println("distance: " + runningDistance.getTotalMeters() + " m");
    }
}
