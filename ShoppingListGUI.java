package Shopping_List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListGUI extends JFrame {
    private ShoppingList shoppingList;
    private JTextArea listTextArea;
    private JTextField nameField, categoryField, quantityField;
    private JButton addButton, removeButton, markPurchasedButton;

    public ShoppingListGUI() {
        setTitle("Shopping List Organizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create the shopping list instance
        shoppingList = new ShoppingList();

        // Create the GUI components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel listPanel = new JPanel(new GridLayout(0, 1));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add items to the shopping list
        shoppingList.addItem(new ShoppingListItem("Apples", "Produce", 5));
        shoppingList.addItem(new ShoppingListItem("Bread", "Bakery", 1));
        shoppingList.addItem(new ShoppingListItem("Eggs", "Dairy", 12));
        shoppingList.addItem(new ShoppingListItem("Chicken Breasts", "Meat", 3));

        // Display the shopping list
        listTextArea = new JTextArea();
        listTextArea.setEditable(false);
        updateShoppingListDisplay();
        JScrollPane listScrollPane = new JScrollPane(listTextArea);
        listPanel.add(listScrollPane);

        // Add input fields
        JLabel nameLabel = new JLabel("Name:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel quantityLabel = new JLabel("Quantity:");
        nameField = new JTextField();
        categoryField = new JTextField();
        quantityField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        // Add buttons
        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Item");
        markPurchasedButton = new JButton("Mark as Purchased");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(markPurchasedButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        markPurchasedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markPurchased();
            }
        });

        mainPanel.add(listPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void updateShoppingListDisplay() {
        listTextArea.setText(shoppingList.viewList());
    }

    private void addItem() {
        String name = nameField.getText();
        String category = categoryField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        shoppingList.addItem(new ShoppingListItem(name, category, quantity));
        updateShoppingListDisplay();
        clearInputFields();
    }

    private void removeItem() {
        String name = nameField.getText();
        shoppingList.removeItem(name);
        updateShoppingListDisplay();
        clearInputFields();
    }

    private void markPurchased() {
        String name = nameField.getText();
        shoppingList.markItemPurchased(name);
        updateShoppingListDisplay();
        clearInputFields();
    }

    private void clearInputFields() {
        nameField.setText("");
        categoryField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingListGUI().setVisible(true);
            }
        });
    }
}