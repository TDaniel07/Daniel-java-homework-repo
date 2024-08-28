import java.util.Scanner;

public class Ex3 {

    public static String expandCompressedString(String compressedString){
        StringBuilder decompressedString = new StringBuilder();

        for(int i = 1; i < compressedString.length(); i++){
            char currentChar = compressedString.charAt(i);

            if(Character.isDigit(currentChar)){
                int charRepeats = 0;
                char charAdd = compressedString.charAt(i - 1);

                while(i < compressedString.length() && Character.isDigit(compressedString.charAt(i))){
                    currentChar = compressedString.charAt(i);
                    charRepeats = charRepeats * 10 + (currentChar - '0');
                    i++;
                }

                for(int j = 1; j <= charRepeats; j++){
                    decompressedString.append(charAdd);
                }
            }
        }

        return decompressedString.toString();
    }

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a compressed string: ");
        String inputString = inputScanner.nextLine();
        System.out.print("\n");

        System.out.println("Decompressed string: " + expandCompressedString(inputString));
    }
}
