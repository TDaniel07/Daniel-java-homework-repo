import java.util.Scanner;

public class Ex2 {

    public static String camelCaseToSnakeCase(String camelCaseText){
        StringBuilder snakeCaseText = new StringBuilder(camelCaseText);

        if(Character.isUpperCase(snakeCaseText.charAt(0)))
            snakeCaseText.setCharAt(0, Character.toLowerCase(snakeCaseText.charAt(0)));

        for(int i = 1; i < snakeCaseText.length(); i++){
            if(Character.isUpperCase(snakeCaseText.charAt(i))){
                snakeCaseText.setCharAt(i, Character.toLowerCase(snakeCaseText.charAt(i)));

                snakeCaseText.insert(i, '_');
            }
        }

        return snakeCaseText.toString();
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter camel case text: ");
        String inputText = inputScanner.nextLine();
        System.out.println("\n");

        System.out.println("Snake case text: " + camelCaseToSnakeCase(inputText));

    }
}
