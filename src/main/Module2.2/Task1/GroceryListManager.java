

import java.util.ArrayList;
public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();
    public void addItem(String item) {
        groceryList.add(item);
    }
    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the grocery list");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");
        manager.displayList();

        String itemToCheck = "Milk";
        System.out.println( "removed " + itemToCheck + " in the grocery list? " + manager.checkItem(itemToCheck));

        System.out.println( "removed " + itemToCheck + " from the list...");
        manager.removeItem(itemToCheck);

        manager.displayList();
    }
}
