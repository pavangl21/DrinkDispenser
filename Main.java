import java.util.HashMap;
import java.util.Map;


class SimpleDrinkDispenser implements DrinkDispenser {
    private Map<Integer, Integer> coinInventory; // Coin inventory
    private Map<String, AllowedDrink> drinkOptions; // Available drinks

    public SimpleDrinkDispenser() {
        coinInventory = new HashMap<>();
        drinkOptions = new HashMap<>();
        initializeCoins();
        initializeDrinks();
    }

    public void initializeCoins() {
        coinInventory.put(5, 10);
        coinInventory.put(10, 10);
        coinInventory.put(20, 10);
        coinInventory.put(50, 10);
        coinInventory.put(100, 10);
        coinInventory.put(200, 10);
    }

    public void initializeDrinks() {
        drinkOptions.put("Coca", new AllowedDrink("Coca", 100));
        drinkOptions.put("Redbull", new AllowedDrink("Redbull", 125));
        drinkOptions.put("Water", new AllowedDrink("Water", 50));
        drinkOptions.put("OrangeJuice", new AllowedDrink("Orange Juice", 195));
    }

    public void displayStockStatus() {
        System.out.println("Coin Inventory: " + coinInventory);
        System.out.println("Drink Options: " + drinkOptions.keySet());
    }

    public String processOrder(int totalCoins, String drinkCode) {
        if (!drinkOptions.containsKey(drinkCode)) {
            return "Invalid drink code";
        }

        AllowedDrink selectedDrink = drinkOptions.get(drinkCode);
        int drinkPrice = selectedDrink.getPrice();

        if (totalCoins < drinkPrice) {
            return "Insufficient funds. Please insert more coins.";
        }

        int change = totalCoins - drinkPrice;
        returnChange(change);

        System.out.println("Dispensing " + selectedDrink.getName());

        return "Dispensing Drink";
    }



    public String returnChange(int change) {
        if (change > 0) {
            System.out.println("Change: " + change + " cents");
            return "Change: " + change + " cents";
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleDrinkDispenser dispenser = new SimpleDrinkDispenser();

        dispenser.displayStockStatus();

        dispenser.processOrder(150, "Coca");

        dispenser.processOrder(50, "Redbull");

        dispenser.processOrder(200, "InvalidDrink");
    }
}
