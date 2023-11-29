public interface DrinkDispenser {
    public void initializeCoins();
    public void initializeDrinks();
    public void displayStockStatus();
    public String processOrder(int totalCoins, String drinkCode);
    public String returnChange(int change);


    }
