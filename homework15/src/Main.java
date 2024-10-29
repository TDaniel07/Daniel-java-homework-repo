import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= 10; i++){
            shoppingCarts.add(ShoppingCart.generateSampleShoppingCart(random.nextInt(30) + 10));
        }

        for (ShoppingCart shoppingCart : shoppingCarts){
            System.out.println(shoppingCart);
        }

        System.out.println("amount of each item");
        ShoppingCart.printSortedAmountOfEachItem(shoppingCarts);

        System.out.println("most purchased items");
        System.out.println(ShoppingCart.getMostPurchasedItems(shoppingCarts, 5));
    }
}