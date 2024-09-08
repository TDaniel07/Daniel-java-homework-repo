import java.util.Scanner;

public class Ex4 {

    public static void countEvenAndOddNumberInArray(int[] array){
        int oddNumbers = 0, evenNumbers = 0;

        for(int element : array){
            if(element % 2 == 0)
                evenNumbers++;
            else
                oddNumbers++;
        }

        System.out.println("even numbers: " + evenNumbers);
        System.out.println("odd numbers: " + oddNumbers);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("enter 10 integers");

        for(int i = 0; i < 10; i++){
            array[i] = inputScanner.nextInt();
        }

        countEvenAndOddNumberInArray(array);





        //This could have been done while the array was getting read but then the array would have become obsolete so I did it in two loops instead of one to actually use the array


        inputScanner.close();
    }
}
