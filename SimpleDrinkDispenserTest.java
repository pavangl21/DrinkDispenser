import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDrinkDispenserTest {

    @Test
    void testProcessOrderValidDrink() {
        SimpleDrinkDispenser dispenser = new SimpleDrinkDispenser();
        dispenser.initializeCoins();
        assertEquals("Dispensing Drink",dispenser.processOrder(150, "Coca"));
    }

    @Test
    void testProcessOrderInvalidDrink() {
        SimpleDrinkDispenser dispenser = new SimpleDrinkDispenser();
        dispenser.initializeCoins();
        assertEquals("Invalid drink code",dispenser.processOrder(150, "InvalidDrink"));
    }

    @Test
    void testProcessOrderInsufficientFunds() {
        SimpleDrinkDispenser dispenser = new SimpleDrinkDispenser();
        dispenser.initializeCoins();
        assertEquals("Insufficient funds. Please insert more coins.",dispenser.processOrder(50, "Coca"));
    }

    @Test
    void testReturnChange() {
        SimpleDrinkDispenser dispenser = new SimpleDrinkDispenser();
        assertEquals("Change: 20 cents",dispenser.returnChange(20));

    }
}