import java.util.Scanner;

public class Ex4 {

    static String commentRemover(String commentedCode){
        StringBuilder code = new StringBuilder(commentedCode);
        boolean isInsideString = false;

        for(int i = 0; i < code.length() - 1; i++){
            char currentChar = code.charAt(i);
            char nextChar = code.charAt(i + 1);

            if(currentChar == '"') {
                isInsideString = !isInsideString;
            }

            if(isInsideString)
                continue;

            if(currentChar == '/' && nextChar == '/')
                code.delete(i, code.length());
            if(currentChar == '/' && nextChar == '*')
                code.delete(i, commentedCode.indexOf("*/") + 2);
        }

        return code.toString();
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Line of code: ");
        String codeLine = inputScanner.nextLine();
        System.out.print("\n");

        System.out.println("Line of code without comments: " + commentRemover(codeLine));
    }
}
