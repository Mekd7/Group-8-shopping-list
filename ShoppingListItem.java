package Shopping_List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShoppingListItem {
    private String name;
    private String category;
    private int quantity;
    private boolean purchased;

    public ShoppingListItem(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.purchased = false;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void markPurchased() {
        this.purchased = true;
    }
}

class ShoppingList {
    private List<ShoppingListItem> items;

    public ShoppingList() {
        this.items = new ArrayList<>();
    }

    public void addItem(ShoppingListItem item) {
        this.items.add(item);
        System.out.println("Added " + item.getName() + " to the shopping list.");
    }

    public void removeItem(String itemName) {
        for (ShoppingListItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                System.out.println("Removed " + item.getName() + " from the shopping list.");
                return;
            }
        }
        System.out.println(itemName + " not found in the shopping list.");
    }

    public void markItemPurchased(String itemName) {
        for (ShoppingListItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.markPurchased();
                System.out.println("Marked " + item.getName() + " as purchased.");
                return;
            }
        }
        System.out.println(itemName + " not found in the shopping list.");
    }

    public String viewList() {
        StringBuilder sb = new StringBuilder();
        for (ShoppingListItem item : items) {
            sb.append(item.getName()).append(" - ").append(item.getCategory()).append(" - ").append(item.getQuantity()).append("\n");
        }
        return sb.toString();
    }

    public void viewCategories() {
        Set<String> categories = new HashSet<>();
        for (ShoppingListItem item : items) {
            categories.add(item.getCategory());
        }
        System.out.println("Shopping List Categories:");
        for (String category : categories) {
            System.out.println("- " + category);
        }
    }
}


