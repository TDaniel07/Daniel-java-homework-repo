package services;

import domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class WorkoutsManager {
    private final ArrayList<Workout> workouts;

    public WorkoutsManager(){
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout newWorkout){
        for(int i = 0; i < workouts.size(); i++){
            Workout currentWorkout = workouts.get(i);

            if(currentWorkout.getStartDateTime().isAfter(newWorkout.getStartDateTime())){
                workouts.add(i, newWorkout);
                return;
            }
        }
        workouts.add(newWorkout);
    }

    public ArrayList<Workout> find(int year){
        ArrayList<Workout> foundWorkouts = new ArrayList<>();

        for(Workout workout : workouts){
            if(workout.getStartDateTime().getYear() == year)
                foundWorkouts.add(workout);
        }

        return foundWorkouts;
    }

    public ArrayList<Workout> find(String type){
        ArrayList<Workout> foundWorkouts = new ArrayList<>();

        for(Workout workout : workouts){
            if(workout.getType().equals(type))
                foundWorkouts.add(workout);
        }

        return foundWorkouts;
    }

    public ArrayList<Workout> findPastWeek(){
        ArrayList<Workout> foundWorkouts = new ArrayList<>();
        LocalDateTime firstDayOfWeek = Utils.getFirstDayOfWeek(LocalDateTime.now());

        for(Workout workout : workouts){
            if(workout.getStartDateTime().isAfter(firstDayOfWeek))
                foundWorkouts.add(workout);
        }

        return foundWorkouts;
    }

    //Function returns copy of workouts arrayList but its elements retain the same reference.
    //FUNCTION RETURN VALUE SHOULD ONLY BE USED FOR PRINTING !!!
    //CALLING THE METHODS OF THE ARRAYLIST ELEMENTS WILL HAVE GLOBAL EFFECTS !!!
    public ArrayList<Workout> getWorkouts(){
        return new ArrayList<>(workouts);
    }

    public static void printWorkoutList(ArrayList<Workout> workouts){
        for(Workout workout : workouts){
            System.out.println("---------");
            workout.printWorkout();
            System.out.println("---------");
        }

        if(workouts.isEmpty())
            System.out.println("There are no workouts in this year");
    }
}
