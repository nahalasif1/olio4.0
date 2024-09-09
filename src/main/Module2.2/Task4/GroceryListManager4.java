
import java.util.HashMap;
public class GroceryListManager4 {
    private HashMap<String, GroceryItem1> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        addItemWithCategoryAndQuantity(item, "Uncategorized", cost, 1);
    }

    public void addItemWithCategory(String item, String category, double cost) {
        addItemWithCategoryAndQuantity(item, category, cost, 1);
    }

    public void addItemWithQuantity(String item, int quantity) {
        addItemWithCategoryAndQuantity(item, "Uncategorized", 0.0, quantity);
    }

    public void addItemWithCategoryAndQuantity(String item, String category, double cost, int quantity) {
        groceryList.put(item, new GroceryItem1(item, category, cost, quantity));
    }

    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).setQuantity(newQuantity);
        } else {
            System.out.println(item + " is not in the grocery list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the grocery list.");
        }
    }
    public void displayList() {
        System.out.println("Grocery List:");
        int i = 1;
        for (GroceryItem1 groceryItem : groceryList.values()) {
            System.out.println(i++ + ". " + groceryItem.getName() + " is " + groceryItem.getCost() + " e (Category: " +
                    groceryItem.getCategory() + ", Quantity: " + groceryItem.getQuantity() + ")");
        }
    }
    public void displayByCategory(String category) {
        System.out.println("Items in Category " + category + ":");
        int i = 1;
        for (GroceryItem1 groceryItem : groceryList.values()) {
            if (groceryItem.getCategory().equalsIgnoreCase(category)) {
                System.out.println(i++ + ". " + groceryItem.getName() + " is " + groceryItem.getCost() + " e" +
                        " (Quantity: " + groceryItem.getQuantity() + ")");
            }
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        int i = 1;
        for (GroceryItem1 groceryItem : groceryList.values()) {
            if (groceryItem.getQuantity() > 0) {
                System.out.println(i++ + ". " + groceryItem.getName() + " (Quantity: " + groceryItem.getQuantity() + ")");
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem1 groceryItem : groceryList.values()) {
            totalCost += groceryItem.getCost() * groceryItem.getQuantity();
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager4 manager = new GroceryListManager4();

        manager.addItemWithCategoryAndQuantity("apples", "Fruits", 3.80, 2);
        manager.addItemWithCategoryAndQuantity("milk", "Dairy", 1.90, 1);
        manager.addItemWithCategoryAndQuantity("bread", "Bakery", 4.00, 3);

        manager.displayList();

        double totalCost = manager.calculateTotalCost();
        System.out.println("Total Cost is " + totalCost);

        String itemToCheck = "Milk";
        if (manager.checkItem(itemToCheck)) {
            System.out.println("Removing " + itemToCheck + " from the list");
            manager.removeItem(itemToCheck);
        }

        manager.displayList();
        totalCost = manager.calculateTotalCost();
        System.out.println("Updated Total Cost " + totalCost);
        manager.displayByCategory("Dairy");
        manager.updateQuantity("apples", 5);
        manager.displayAvailableItems();
    }
}
class GroceryItem1 {
    private String name;
    private String category;
    private double cost;
    private int quantity;

    public GroceryItem1(String name, String category, double cost, int quantity) {
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
