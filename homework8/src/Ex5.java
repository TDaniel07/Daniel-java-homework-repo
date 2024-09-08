import java.util.ArrayList;
import java.util.Scanner;

public class Ex5 {

    public static void addCity(ArrayList<String> cityNames,String city){
        for(String cityName : cityNames){
            if(cityName.equals(city)){
                System.out.println("city name is duplicate");
                return;
            }
        }
        cityNames.add(city);
        System.out.println("city name added");
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<String> cityNames = new ArrayList<>();

        cityNames.add("Giurgiu");
        cityNames.add("Bucuresti");
        cityNames.add("Timisoara");
        cityNames.add("Sibiu");
        cityNames.add("Iasi");

        System.out.println(cityNames);

        System.out.print("Enter a city name: ");

        String cityInput = inputScanner.nextLine();

        addCity(cityNames, cityInput);

        System.out.println(cityNames);

        inputScanner.close();
    }
}
