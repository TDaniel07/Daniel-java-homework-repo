import java.util.ArrayList;
import java.util.Arrays;

public class Ex7 {

    //If this function returns true then the fruits are not sorted
    //I assume the exercise wants me when sorting alphabetically to also sort them in descending order
    public static boolean areFruitsSorted(String leftFruit, String rightFruit){
        int fruitLeftLength = leftFruit.length();
        int fruitRightLength = rightFruit.length();

        if(fruitLeftLength == fruitRightLength){ //I could have simplified this condition but I chose to write it this way to improve readability
            if(leftFruit.compareTo(rightFruit) < 0)
                return false;
            else
                return true;
        }

        return fruitLeftLength > fruitRightLength;

    }

    //The only sorting algorithm which I know is bubble sort, which I know has a bad time complexity but in the national competitions they allow us to use STL functions including sorting ones which are very fast. Might learn faster ones in the future but at my level this is the best I know how to implement myself.

    public static void sortFruitsDescending(ArrayList<String> fruitsArray){
        boolean sorted;
        int max = fruitsArray.size() - 1;

        do{
            sorted = true;

            for(int i = 0; i < max; i++){
                String leftFruit = fruitsArray.get(i);
                String rightFruit = fruitsArray.get(i + 1);

                if(!areFruitsSorted(leftFruit, rightFruit)){
                    fruitsArray.set(i, rightFruit);
                    fruitsArray.set(i + 1, leftFruit);
                    sorted = false;

                }
            }
            max--;
        }while(!sorted);
    }

    public static void main(String[] args) {
        String[] fruitsArray = {"mar", "para", "banana", "piersica", "ananas", "mango", "strugure", "visina"};
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList(fruitsArray));

        sortFruitsDescending(fruits);

        System.out.println(fruits);





    }
}
