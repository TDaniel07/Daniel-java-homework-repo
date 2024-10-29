import java.util.*;

public class ShoppingCart {
    private final ArrayList<String> shoppingCart;

    public ShoppingCart(){
        shoppingCart = new ArrayList<>();
    }

    public ShoppingCart(ArrayList<String> shoppingCart){
        this.shoppingCart = new ArrayList<>(shoppingCart);
    }

    public void add(String id) {
        shoppingCart.add(id);
    }

    public void remove(String id){
        shoppingCart.remove(id);
    }

    public ArrayList<String> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    public static void printSortedAmountOfEachItem(ArrayList<ShoppingCart> shoppingCarts){
        HashMap<String, Integer> items = new HashMap<>();

        for(ShoppingCart shoppingCart : shoppingCarts){
            for(String item : shoppingCart.getShoppingCart()){
                items.put(item, items.getOrDefault(item, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> sortedItems = new ArrayList<>(items.entrySet());
        sortedItems.sort(new ItemComparator().reversed());

        for(Map.Entry<String, Integer> item : sortedItems){
            System.out.printf("id: %s amount: %d\n", item.getKey(), item.getValue());
        }
    }

    public static ArrayList<String> getMostPurchasedItems(ArrayList<ShoppingCart> shoppingCarts, int numberOfItems){
        if(numberOfItems <= 0)
            throw new IllegalArgumentException("numberOfItems must be strictly bigger than 0");

        HashMap<String, Integer> items = new HashMap<>();

        for(ShoppingCart shoppingCart : shoppingCarts){
            for(String item : shoppingCart.getShoppingCart()){
                items.put(item, items.getOrDefault(item, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> sortedItems = new ArrayList<>(items.entrySet());
        sortedItems.sort(new ItemComparator().reversed());

        ArrayList<String> mostPurchasedItems = new ArrayList<>();
        int passedItems = 1;
        mostPurchasedItems.add(sortedItems.getFirst().getKey());
        for(int i = 1; i < sortedItems.size(); i++){
            if(!Objects.equals(sortedItems.get(i).getValue(), sortedItems.get(i - 1).getValue()))
                passedItems++;
            if(passedItems > numberOfItems)
                break;
            mostPurchasedItems.add(sortedItems.get(i).getKey());

        }
        return mostPurchasedItems;
    }

    @Override
    public String toString(){
        return shoppingCart.toString();
    }

    public static ShoppingCart generateSampleShoppingCart(int numberOfItems){
        ArrayList<String> sampleShoppingCart = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= numberOfItems; i++){
            int id = random.nextInt(100) + 1;
            sampleShoppingCart.add(String.valueOf(id));
        }

        return new ShoppingCart(sampleShoppingCart);
    }
}
