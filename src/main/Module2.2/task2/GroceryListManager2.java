import java.util.HashMap;
import java.util.Map;

public class GroceryListManager2 {
    private HashMap<String, Double> groceryList = new HashMap<>();
    public void addItem(String item, double cost) {
        groceryList.put(item, cost);
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
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            System.out.println(i++ + ". " + entry.getKey() + "  is " + entry.getValue() + " e") ;
        }
    }
    public boolean checkItem(String item) {
        return groceryList.containsKey( item);
    }


    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager2 manager = new GroceryListManager2();


        manager.addItem("apples", 3.80);
        manager.addItem("milk", 1.90);
        manager.addItem("bread", 4.00);

        manager.displayList();

        double totalCost = manager.calculateTotalCost();
        System.out.println("Total Cost is " + totalCost);

        String itemToCheck = "milk";
        if (manager.checkItem(itemToCheck)) {
            System.out.println("Removing" + itemToCheck + " from the list");
            manager.removeItem(itemToCheck);
        }


        manager.displayList();
        totalCost = manager.calculateTotalCost();
        System.out.println("Updated Total Cost " + totalCost);
    }
}
