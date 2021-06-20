import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

import junit.framework.TestCase;


class MenuItem {
	private String item;
	private String type;
	private double price;
	
	public MenuItem(String item, String type, double price) {
		this.item = item;
		this.type = type;
		this.price = price;
	}

	public String getItem() { return item; }
	public String getType() { return type; }
	public double getPrice() { return price; }
}

class CoffeeShop{
	String name;
    MenuItem [] menu;
    String [] orders;
    double dueAmount = 0;
    private boolean emptyOrders() {

        return orders.length == 0;
    }
    private boolean menuContainsThis(String name)
    {
        for (MenuItem menuItem : menu) {
            
            if (menuItem.getItem() == name)
                return true;
        }
        
        return false;
    }

    private double getPriceOfItemInMenu(String name)
    {
        for (MenuItem menuItem : menu) {
            
            if (menuItem.getItem() == name)
                return menuItem.getPrice();
        }
        
        return -1;
    }
    
    private void addItemToOrdersList(String name)
    {
        orders = Arrays.copyOf(orders, orders.length + 1);
        orders[orders.length - 1] = name;
        dueAmount += this.getPriceOfItemInMenu(name);
    }
    
    private String removeItemFromOrdersList() {

        if (this.emptyOrders())
            return "";
        String removedItem = orders[0];
        orders = Arrays.copyOfRange(orders, 1, orders.length);
        dueAmount -= this.getPriceOfItemInMenu(removedItem);
        return removedItem;

    }
    
    public CoffeeShop(String name, MenuItem[] menu, String [] orders)
    {
        this.name = name;
        this.menu = menu;
        this.orders = orders;
    }

    public String addOrder(String name) {

        if (this.menuContainsThis(name))
        {
            this.addItemToOrdersList(name);
            return "Order added!";
        }
        
        return "This item is currently unavailable!";
    }
    
    public String fulfillOrder() {

        if (this.emptyOrders())
        {
            return "All orders have been fulfilled!";
        }

        return "The " + this.removeItemFromOrdersList() + " is ready!";
    }
    
    public String [] listOrders() {

        return this.orders;
    }

    public double dueAmount() {

        return this.dueAmount;
    }

    public String cheapestItem() {

        String name = "";
        double cost = 100000000.0;

        for (MenuItem menuItem : menu) {
            
            if (menuItem.getPrice() < cost) {

                name = menuItem.getItem();
                cost = menuItem.getPrice();
            }
        }

        return name;
    }

    public String [] drinksOnly() {

        String [] drinkList = new String[menu.length];
        int count = 0;

        for (MenuItem menuItem: menu) {
            
            if (menuItem.getType().equals("drink")) {

                drinkList[count++] = menuItem.getItem();
            }
        }

        drinkList = Arrays.copyOfRange(drinkList, 0, count);

        return drinkList;
    }

    public String [] foodOnly() {

        String [] foodList = new String[menu.length];
        int count = 0;

        for (MenuItem menuItem: menu) {
            
            if (menuItem.getType().equals("food")) {

                foodList[count++] = menuItem.getItem();
            }
        }

        foodList = Arrays.copyOfRange(foodList, 0, count);

        return foodList;
    }
}

@Test
public class CoffeeShopChallenge extends TestCase{

    @Test
    public static void main(String[] args) {
        
        MenuItem[] menu = new MenuItem[] {
            new MenuItem("orange juice", "drink", 2.13), new MenuItem("lemonade", "drink", 0.85), new MenuItem("cranberry juice", "drink", 3.36), 
            new MenuItem("pineapple juice", "drink", 1.89), new MenuItem("lemon iced tea", "drink", 1.28), new MenuItem("apple iced tea", "drink", 1.28), 
            new MenuItem("vanilla chai latte", "drink", 2.48), new MenuItem("hot chocolate", "drink", 0.99), new MenuItem("iced coffee", "drink", 1.12), 
            new MenuItem("tuna sandwich", "food", 0.95), new MenuItem("ham and cheese sandwich", "food", 1.35), new MenuItem("bacon and egg", "food", 1.15), 
            new MenuItem("steak", "food", 3.28), new MenuItem("hamburger", "food", 1.05), new MenuItem("cinnamon roll", "food", 1.05) };
            CoffeeShop shop = new CoffeeShop("Deep Into Coffee", menu, new String[] {});
        
            assertEquals("Order added!", shop.addOrder("cinnamon roll")); 
            assertEquals("Order added!", shop.addOrder("iced coffee"));
            assertArrayEquals(new String[] {"cinnamon roll", "iced coffee"}, shop.listOrders());
            assertEquals(2.17, shop.dueAmount(), 6);
            assertEquals("The cinnamon roll is ready!", shop.fulfillOrder());
            assertEquals("The iced coffee is ready!", shop.fulfillOrder());
            assertEquals("All orders have been fulfilled!", shop.fulfillOrder());
            assertEquals("This item is currently unavailable!", shop.addOrder("hot cocoa"));
            assertEquals("This itesm is currently unavailable!", shop.addOrder("iced tea"));
            assertArrayEquals(new String[] {}, shop.listOrders());
            assertEquals(0.0, shop.dueAmount(), 6);
            assertEquals("lemonade", shop.cheapestItem());
            assertArrayEquals(new String[] {"orange juice", "lemonade", "cranberry juice", "pineapple juice", "lemon iced tea", "apple iced tea", "vanilla chai latte", "hot chocolate", "iced coffee"}, shop.drinksOnly());
            assertArrayEquals(new String[] {"tuna sandwich", "ham and cheese sandwich", "bacon and egg", "steak", "hamburger", "cinnamon roll"}, shop.foodOnly());
            
    }
    
    @Test
	public void test02() {
        MenuItem[] menu = new MenuItem[] {
            new MenuItem("turkey english muffin", "food", 7.99), new MenuItem("avocado toast", "food", 5.05), new MenuItem("chocolate croissant", "food", 3.00),
            new MenuItem("espresso", "drink", 2.99), new MenuItem("iced caramel macchiato", "drink", 4.50), new MenuItem("cortado", "drink", 4.00),
            new MenuItem("nitro cold brew tester", "drink", 8.00) };
        CoffeeShop shop = new CoffeeShop("Xavier's", menu, new String[] {});

		assertEquals("Order added!", shop.addOrder("cortado"));
		assertEquals(4.0, shop.dueAmount(), 6);
		assertEquals("The cortado is ready!", shop.fulfillOrder());
		assertEquals("All orders have been fulfilled!", shop.fulfillOrder());
		assertEquals("Order added!", shop.addOrder("avocado toast"));
		assertEquals(5.05, shop.dueAmount(), 6);
		assertArrayEquals(new String[] {"avocado toast"}, shop.listOrders());
		assertEquals("espresso", shop.cheapestItem());
		assertArrayEquals(new String[] {"espresso", "iced caramel macchiato", "cortado", "nitro cold brew tester"}, shop.drinksOnly());
		assertArrayEquals(new String[] {"turkey english muffin", "avocado toast", "chocolate croissant"}, shop.foodOnly());
	}
}   