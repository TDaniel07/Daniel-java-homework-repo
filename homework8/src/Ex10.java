import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

class Diary{
    private ArrayList<String> diaryList;
    private DateTimeFormatter format;

    Diary(){
        diaryList = new ArrayList<>();
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public void add(String entry){
        String[] parsedEntry = entry.split(":", 2);

        if(parsedEntry.length != 2){
            System.out.println("Entered format is not valid");
            return;
        }

        String entryDateString = parsedEntry[0];
        String entryContent = parsedEntry[1];

        if(!isValidDate(entryDateString)){
            System.out.println("Entered date format is not valid");
            return;
        }

        LocalDate entryDate = LocalDate.parse(entryDateString, format);

        for(int i = 0; i < diaryList.size(); i++){
            LocalDate diaryDate = getDiaryDate(i);

            if(diaryDate.isEqual(entryDate)){
                System.out.println("Date already exists");
                return;
            }

            if(diaryDate.isAfter(entryDate)){
                diaryList.add(i, entry);
                System.out.println("Entry successfully added in diary");
                return;
            }
        }

        diaryList.add(entry);
        System.out.println("Entry successfully added in diary");
    }

    public void edit(String entryDateString, String newEntryContent){
        if(!isValidDate(entryDateString)){
            System.out.println("Entered date is not valid");
            return;
        }

        LocalDate entryDate = LocalDate.parse(entryDateString, format);

        for(int i = 0; i < diaryList.size(); i++){
            LocalDate diaryDate = getDiaryDate(i);
            if(diaryDate.isEqual(entryDate)){
                diaryList.set(i, diaryDate.format(format) + ":" + newEntryContent);
                System.out.println("Entry successfully edited");
                return;
            }
        }
        System.out.println("Entered date is not present in diary");
    }

    public void delete(String entryDateString){
        if(!isValidDate(entryDateString)){
            System.out.println("Entered date is not valid");
            return;
        }

        LocalDate entryDate = LocalDate.parse(entryDateString, format);

        for(int i = 0; i < diaryList.size(); i++){
            LocalDate diaryDate = getDiaryDate(i);
            if(diaryDate.isEqual(entryDate)){
                diaryList.remove(i);
                System.out.println("Entry successfully deleted");
                return;
            }
        }
        System.out.println("Entered date is not present in diary");
    }

    public void display(){
        for(int i = diaryList.size() - 1; i >= 0; i--)
            System.out.println(diaryList.get(i));
    }

    private LocalDate getDiaryDate(int index){
        return LocalDate.parse(diaryList.get(index).split(":")[0], format);
    }

    private boolean isValidDate(String date){
        try{
            LocalDate.parse(date, format);
        }catch (DateTimeParseException error){
            return false;
        }
        return true;
    }
}

public class Ex10 {
    public static void main(String[] args) {
        Diary diary = new Diary();

        System.out.println("==== Diary ====");
        show_commands();

        Scanner inputScanner = new Scanner(System.in);
        boolean programIsRunning = true;

        while (programIsRunning){
            System.out.print(">");

            String userInput = inputScanner.nextLine();

            String[] parsedUserInput = userInput.split(" ", 2);
            String command = parsedUserInput[0].trim();

            switch (command){
                case "add" ->{
                    if(parsedUserInput.length != 2){
                        System.out.println("you need to provide parameters for this function");
                        continue;
                    }

                    String parameters = parsedUserInput[1].trim();
                    diary.add(parameters);
                }
                case "edit" ->{
                    if(parsedUserInput.length != 2){
                        System.out.println("you need to provide parameters for this function");
                        continue;
                    }
                    String parameters = parsedUserInput[1].trim();

                    String[] parsedCommandParameters = parameters.split(" ", 2);
                    String commandDate = parsedCommandParameters[0].trim();
                    String commandNewEntry = parsedCommandParameters[1].trim();

                    diary.edit(commandDate, commandNewEntry);
                }
                case "delete" ->{
                    if(parsedUserInput.length != 2){
                        System.out.println("you need to provide parameters for this function");
                        continue;
                    }
                    String parameters = parsedUserInput[1].trim();
                    diary.delete(parameters);
                }
                case "display" -> diary.display();
                case "help" -> show_commands();
                case "exit" -> programIsRunning = false;
                default -> System.out.println("entered command is not valid");
            }
        }
    }

    public static void show_commands() {
        System.out.println("add <YYYY-MM-DD>:<diary entry> - adds a new entry to the diary");
        System.out.println("edit <YYYY-MM-DD> <new diary entry> - edits an already existing entry");
        System.out.println("delete <YYYY-MM-DD> - deletes an already existing entry");
        System.out.println("display - displays the diary");
        System.out.println("help - displays again all commands");
        System.out.println("exit - exits the program");
    }
}
