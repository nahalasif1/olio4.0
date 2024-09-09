
import java.util.HashMap;
public class GroceryListManager3 {
    private HashMap<String, GroceryItem> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        addItemWithCategory(item, "uncategorized", cost);
    }

    public void addItemWithCategory(String item, String category, double cost) {
        groceryList.put(item, new GroceryItem(item, category, cost));
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
        for (GroceryItem groceryItem : groceryList.values()) {
            System.out.println(i++ + ". " + groceryItem.getName() + " is " + groceryItem.getCost() + " e (Category: " + groceryItem.getCategory() + ")");
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in Category " + category + ":");
        int i = 1;
        for (GroceryItem groceryItem : groceryList.values()) {
            if (groceryItem.getCategory().equalsIgnoreCase(category)) {
                System.out.println(i++ + ". " + groceryItem.getName() + " is " + groceryItem.getCost() + " e");
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem groceryItem : groceryList.values()) {
            totalCost += groceryItem.getCost();
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager3 manager = new GroceryListManager3();

        manager.addItemWithCategory("apples", "Fruits", 4.0);
        manager.addItemWithCategory("milk", "Dairy", 2.50);
        manager.addItemWithCategory("bread", "Bakery", 3.00);

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
    }
}

class GroceryItem {
    private String name;
    private String category;
    private double cost;

    public GroceryItem(String name, String category, double cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
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
}