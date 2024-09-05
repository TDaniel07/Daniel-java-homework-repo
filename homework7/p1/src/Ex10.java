import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex10 {
    //Stiu ca nu am discutat inca despre erori si gestionarea lor insa fiind extrem de similar cu c++ m-am gandit sa folosesc aceasta metoda.
    //Cealalta modalitate la care m-am gandit ar fi fost sa fi verificat manual daca numarul de zile este valid pentru fiecare luna, ceea ce ar fi fost lucru manual ;) si ca si programator daca exista o metoda la fel de rapida cu mai putin cod o prefer pe accea.
    //Nu stiu daca este de la IntelliJ sau de la JDK dar toate functiile sunt foarte bine documentate, imi este dat inclusiv ce erori sunt aruncate in functie de ce problema ar putea aparea.
    public static boolean isValidDate(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String dateString = inputScanner.nextLine();
        inputScanner.close();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            return true;
        }
        catch (DateTimeParseException error){
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isValidDate());
    }
}
