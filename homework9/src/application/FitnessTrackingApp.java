package application;

import domain.*;
import services.WorkoutsManager;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FitnessTrackingApp {

    private WorkoutsManager workoutsManager;
    private Scanner inputScanner;
    private WorkoutGoal workoutGoal = null;

    public void startApp() {
        inputScanner = new Scanner(System.in);
        workoutsManager = new WorkoutsManager();
        
        System.out.println("==== Fitness Tracking App ====");
        showCommands();

        boolean appIsRunning = true;
        while (appIsRunning) {
            System.out.print(">");

            String userInput = inputScanner.nextLine();

            String[] parsedUserInput = userInput.split(" ", 2);
            String command = parsedUserInput[0];

            switch (command) {
                case "display" -> {
                    if (parsedUserInput.length < 2) {
                        System.out.println("Invalid parameters for this command");
                        continue;
                    }

                    String[] parameters = parsedUserInput[1].trim().split(" ");
                    display(parameters);
                }
                case "goal" ->{
                    if(parsedUserInput.length != 2){
                        System.out.println("Invalid parameter for this command");
                        continue;
                    }

                    String parameter = parsedUserInput[1].trim();
                    goals(parameter);
                }
                case "add" -> add();
                case "help" -> showCommands();
                case "exit" -> appIsRunning = false;
                default -> System.out.println("Entered command is not valid");
            }
        }
    }

    private void goals(String parameter) {
        try {
            switch (parameter) {
                case "add" -> {
                    System.out.println("1.Number of workouts goal");
                    int workoutsGoal = readInteger();
                    System.out.println("2.Distance run goal (meters)");
                    int distanceRunGoal = readInteger();
                    System.out.println("3.Weight lifted goal (kg)");
                    int weightLiftedGoal = readInteger();
                    System.out.println("4.Total workout time goal (hours)");
                    int workoutTimeGoal = readInteger();

                    workoutGoal = new WorkoutGoal(LocalDateTime.now(), workoutsGoal, distanceRunGoal, weightLiftedGoal, workoutTimeGoal);
                }
                case "show" ->{
                    if(workoutGoal == null){
                        System.out.println("You have not yet created a goal");
                        return;
                    }
                    if(workoutGoal.getGoalEndDate().isAfter(LocalDateTime.now())){
                        System.out.println("Workout goal has expired. Create a new one");
                        return;
                    }

                    System.out.printf("Number of workouts: %d/%d\n", workoutGoal.getTotalWorkouts(), workoutGoal.getWorkoutsGoal());
                    System.out.printf("Distance run: %d/%d\n", workoutGoal.getTotalDistanceRun(), workoutGoal.getDistanceRunGoal());
                    System.out.printf("Weight lifted goal: %d/%d\n", workoutGoal.getTotalWeightLifted(), workoutGoal.getWeightLiftedGoal());
                    System.out.printf("Total workout time: %d/%d(hours)\n", workoutGoal.getTotalWorkoutTimeHours(), workoutGoal.getWorkoutTimeGoal());
                }
                case "delete" ->{
                    workoutGoal = null;
                    System.out.println("Workout goal successfully deleted");
                }
                default -> {
                    System.out.println("invalid parameter for this command");
                }
            }
        } catch (RuntimeException error){
            System.out.println("Invalid input");
        }
    }


    private void add(){
        System.out.println("==== ADD NEW WORKOUT ====");
        showWorkouts();

        try {
            System.out.println("1.Enter workout type");
            String workoutType = readWorkoutType();


            LocalDateTime workoutDate = LocalDateTime.now();

            System.out.println("2.Enter the duration of the workout (hours:minutes)");
            System.out.println("*If minutes exceed 60 conversion will be done automatically");
            System.out.println("*There is no limit to how many hours you may input");
            String durationString = readWorkoutDuration();
            Duration workoutDuration = Workout.convertDuration(durationString);


            switch (workoutType) {
                case "yoga" -> {
                    YogaWorkout workout = new YogaWorkout(workoutDate, workoutDuration);
                    workoutsManager.addWorkout(workout);

                    if(workoutGoal != null)
                        workoutGoal.updateTotalStatistics(workout);
                }
                case "weightlifting" -> {
                    System.out.println("Enter weight(kg)");
                    int weight = readInteger();

                    System.out.println("Enter reps");
                    int reps = readInteger();

                    WeightliftingWorkout workout = new WeightliftingWorkout(workoutDate, workoutDuration, weight, reps);
                    workoutsManager.addWorkout(workout);

                    if(workoutGoal != null)
                        workoutGoal.updateTotalStatistics(workout);
                }
                case "push ups" -> {
                    System.out.println("Enter reps");
                    int reps = readInteger();

                    PushUpsWorkout workout = new PushUpsWorkout(workoutDate, workoutDuration, reps);
                    workoutsManager.addWorkout(workout);

                    if(workoutGoal != null)
                        workoutGoal.updateTotalStatistics(workout);
                }
                case "running" -> {
                    System.out.println("Enter running distance(meters)");
                    int distanceInt = readInteger();
                    Distance distance = new Distance();
                    distance.addMeters(distanceInt);

                    RunningWorkout workout = new RunningWorkout(workoutDate, workoutDuration, distance);
                    workoutsManager.addWorkout(workout);

                    if(workoutGoal != null)
                        workoutGoal.updateTotalStatistics(workout);
                }
            }
        }
        catch (IllegalArgumentException error){
            System.out.println("Two workouts cannot have the same date and time");
        }
        catch (RuntimeException error){
            System.out.println("Prompt cancelled due to invalid input. Try again");
        }
    }

    private int readInteger(){
        System.out.print(">");
        int input = Integer.parseInt(inputScanner.nextLine());
        if(input < 0)
            throw new RuntimeException("Invalid input");
        return input;
    }

    private String readWorkoutType(){
        System.out.print(">");
        String input = inputScanner.nextLine();
        if(!Workout.isValidWorkoutType(input))
            throw new RuntimeException("Invalid input");
        return input;

    }

    private String readWorkoutDate(){
        System.out.print(">");
        String input = inputScanner.nextLine();
        if(!Workout.isValidDate(input))
            throw new RuntimeException("Invalid input");
        return input;
    }

    private String readWorkoutDuration(){
        System.out.print(">");
        String input = inputScanner.nextLine();
        if(!Workout.isValidDuration(input))
            throw  new RuntimeException("Invalid input");
        return input;
    }

    private void showWorkouts(){
        System.out.println("1.Enter workout type");
        System.out.println("workout types: ");
        System.out.println("* push ups");
        System.out.println("* running");
        System.out.println("* weightlifting");
        System.out.println("* yoga");
        System.out.println();
    }

    private void display(String[] parameters){
        switch (parameters[0]){
            case "all" ->{
                ArrayList<Workout> workouts = workoutsManager.getWorkouts();

                System.out.println("==== ALL WORKOUTS ====");
                for(Workout workout : workouts){
                    System.out.println("---------");
                    workout.printWorkout();
                    System.out.println("---------");
                }
            }
            case "year" ->{
                if(parameters.length != 2 || !Utils.isInteger(parameters[1]) || Integer.parseInt(parameters[1]) <= 0){
                    System.out.println("invalid parameters for this command");
                    return;
                }

                int year = Integer.parseInt(parameters[1]);

                ArrayList<Workout> foundWorkouts = workoutsManager.find(year);

                WorkoutsManager.printWorkoutList(foundWorkouts);
            }
            case "type" ->{
                if(parameters.length < 2 || !Workout.isValidWorkoutType(parameters[1])){
                    System.out.println("invalid parameters for this command");
                    return;
                }

                String type = parameters[1];

                ArrayList<Workout> foundWorkouts = workoutsManager.find(type);

                WorkoutsManager.printWorkoutList(foundWorkouts);
            }
            case "summary" ->{
                ArrayList<Workout> foundWorkouts = workoutsManager.findPastWeek();

                WorkoutsManager.printWorkoutList(foundWorkouts);

                if(workoutGoal == null){
                    System.out.println("You have not yet set a weekly workout goal");
                }
                else if(workoutGoal.isWorkoutGoalCompleted())
                    System.out.println("Your weekly goal has been completed");
                else
                    System.out.println("You have not yet completed your weekly goal");
            }
            default -> System.out.println("Invalid parameters for display");
        }
    }

    private void showCommands(){
        System.out.println("add - begins prompt to add a new workout");
        System.out.println("goal add - begins prompt to add a goal(will delete the current goal if it exists");
        System.out.println("goal show - shows current goal");
        System.out.println("goal delete - deletes the current goal");
        System.out.println("display all - shows all workouts");
        System.out.println("display year <yyyy> - shows all workouts in a specific year");
        System.out.println("display summary - shows all workouts in the past week");
        System.out.println("help - shows all commands");
        System.out.println("exit - exits the program");
    }
}
