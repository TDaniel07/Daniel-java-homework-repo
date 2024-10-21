package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class WorkoutGoal {
    private int workoutsGoal;
    private int distanceRunGoal; //in meters
    private int weightLiftedGoal; //in kg
    private long workoutTimeGoal; //in hours
    private LocalDateTime goalBeginDate;
    private LocalDateTime goalEndDate;
    private int totalWorkouts;
    private int totalDistanceRun;
    private int totalWeightLifted;
    private Duration totalWorkoutTime;

    public WorkoutGoal(LocalDateTime goalBeginDate){
        this.goalBeginDate = goalBeginDate;
        workoutsGoal = 0;
        distanceRunGoal = 0;
        weightLiftedGoal = 0;
        workoutTimeGoal = 0;
        goalEndDate = Utils.getLastDayOfWeek(goalBeginDate);
        totalWorkoutTime = Duration.ofSeconds(0);
    }

    public WorkoutGoal(LocalDateTime goalBeginDate, int workoutsGoal, int distanceRun, int weightLifted, long workoutTime){
        this.workoutsGoal = workoutsGoal;
        this.goalBeginDate = goalBeginDate;
        this.distanceRunGoal = distanceRun;
        this.weightLiftedGoal = weightLifted;
        this.workoutTimeGoal = workoutTime;
        goalEndDate = Utils.getLastDayOfWeek(goalBeginDate);
        totalWorkoutTime = Duration.ofSeconds(0);
    }

    public void updateTotalStatistics(Workout workout){
        totalWorkoutTime = totalWorkoutTime.plus(workout.getDuration());
        totalWorkouts++;

        switch (workout.getType()){
            case "running" ->{
                RunningWorkout runningWorkout = (RunningWorkout) workout;
                totalDistanceRun += runningWorkout.getDistanceInTotalMeters();
            }
            case "weightlifting" ->{
                WeightliftingWorkout weightliftingWorkout = (WeightliftingWorkout) workout;
                totalWeightLifted += weightliftingWorkout.getWeight();
            }
        }
    }

    public boolean isWorkoutGoalCompleted(){
        return totalWorkouts >= workoutsGoal && totalWorkoutTime.toHours() >= workoutTimeGoal && totalDistanceRun >= distanceRunGoal && totalWeightLifted >= weightLiftedGoal;
    }

    public LocalDateTime getGoalBeginDate() {
        return goalBeginDate;
    }

    public LocalDateTime getGoalEndDate() {
        return goalEndDate;
    }

    public int getWorkoutsGoal() {
        return workoutsGoal;
    }

    public int getDistanceRunGoal(){
        return distanceRunGoal;
    }

    public int getWeightLiftedGoal(){
        return weightLiftedGoal;
    }

    public long getWorkoutTimeGoal() {
        return workoutTimeGoal;
    }

    public int getTotalWorkouts() {
        return totalWorkouts;
    }

    public int getTotalWeightLifted() {
        return totalWeightLifted;
    }

    public int getTotalDistanceRun() {
        return totalDistanceRun;
    }

    public long getTotalWorkoutTimeHours() {
        return totalWorkoutTime.toHours();
    }

}
