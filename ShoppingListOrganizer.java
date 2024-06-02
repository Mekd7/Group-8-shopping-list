package Shopping_List;


public class ShoppingListOrganizer {
    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();

        shoppingList.addItem(new ShoppingListItem("Apples", "Produce", 5));
        shoppingList.addItem(new ShoppingListItem("Bread", "Bakery", 1));
        shoppingList.addItem(new ShoppingListItem("Eggs", "Dairy", 12));
        shoppingList.addItem(new ShoppingListItem("Chicken Breasts", "Meat", 3));

        shoppingList.viewList();
        System.out.println();

        shoppingList.markItemPurchased("Bread");
        shoppingList.viewList();
        System.out.println();

        shoppingList.removeItem("Eggs");
        shoppingList.viewList();
        System.out.println();

        shoppingList.viewCategories();

    }
}

