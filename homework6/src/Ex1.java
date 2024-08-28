import java.util.Scanner;

public class Ex1 {

    public static String caesarEncrypt(String text, int shift){
        StringBuilder encryptedText = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            char currentChar = text.charAt(i);

            if(Character.isAlphabetic(currentChar)){
                int nextCharDec = currentChar + shift;
                int maxAsciiValue;

                if(Character.isLowerCase(currentChar))
                    maxAsciiValue = 122;
                else
                    maxAsciiValue = 90;

                while (nextCharDec > maxAsciiValue)
                    nextCharDec -= 26;

                encryptedText.append((char)nextCharDec);
            }
            else
                encryptedText.append(' ');
        }

        return encryptedText.toString();
    }

    public static String caesarDecrypt(String text, int shift){
        StringBuilder decryptedText = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            char currentChar = text.charAt(i);

            if(Character.isAlphabetic(currentChar)){
                int nextCharDec = currentChar - shift;
                int minAsciiValue;

                if(Character.isLowerCase(currentChar))
                    minAsciiValue = 97;
                else
                    minAsciiValue = 65;

                while (nextCharDec < minAsciiValue)
                    nextCharDec += 26;

                decryptedText.append((char)nextCharDec);
            }
            else
                decryptedText.append(' ');
        }

        return decryptedText.toString();
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String inputText = inputScanner.nextLine();
        System.out.println("\n");

        System.out.print("Enter cipher shift: ");

        int shift = inputScanner.nextInt();
        System.out.println("\n");

        String encryptedText = caesarEncrypt(inputText, shift);

        System.out.println("Encrypted text " + encryptedText);
        System.out.println("Decrypted text " + caesarDecrypt(encryptedText, shift));



    }
}
