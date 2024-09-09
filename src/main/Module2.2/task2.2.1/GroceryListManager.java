import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (item.isBlank()) {
            System.out.println("Error: Item name cannot be empty.");
            return;
        }
        if (!groceryList.contains(item)) {
            groceryList.add(item);
            System.out.println("Added \"" + item + "\" to the grocery list.");
        } else {
            System.out.println("\"" + item + "\" is already in the grocery list.");
        }
    }

    public void removeItem(String item) {
        if (item.isBlank()) {
            System.out.println("Error: Item name cannot be empty.");
            return;
        }
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println("Removed \"" + item + "\" from the grocery list.");
        } else {
            System.out.println("\"" + item + "\" is not in the grocery list.");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("Grocery list is empty.");
        } else {
            System.out.println("Grocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Display list");
            System.out.println("4. Check item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter item to add: ");
                    String addItem = scanner.nextLine();
                    manager.addItem(addItem);
                    break;
                case 2:
                    System.out.print("Enter item to remove: ");
                    String removeItem = scanner.nextLine();
                    manager.removeItem(removeItem);
                    break;
                case 3:
                    manager.displayList();
                    break;
                case 4:
                    System.out.print("Enter item to check: ");
                    String checkItem = scanner.nextLine();
                    System.out.println("\"" + checkItem + "\" is in the grocery list: " + manager.checkItem(checkItem));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}