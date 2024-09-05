import java.util.Scanner;

public class Ex6 {

    public static String toggleCase(String text){
        StringBuilder toggledText = new StringBuilder(text);

        for(int i = 0; i < toggledText.length(); i++){
            char currentChar = toggledText.charAt(i);

            if(!Character.isAlphabetic(currentChar))
                continue;

            if(Character.isUpperCase(currentChar))
                toggledText.setCharAt(i, Character.toLowerCase(currentChar));
            else
                toggledText.setCharAt(i, Character.toUpperCase(currentChar));
        }

        return toggledText.toString();
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String inputText = inputScanner.nextLine();
        System.out.print("\n");

        System.out.println("Text with toggled case: " + toggleCase(inputText));
    }
}
