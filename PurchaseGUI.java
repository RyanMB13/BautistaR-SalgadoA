import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseGUI extends JFrame {

    private final List<Item> uniqueItemList;

    public PurchaseGUI(List<Item> uniqueItemList) {
        this.uniqueItemList = uniqueItemList;

        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Item Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 1. Adding a label on the north center saying "Purchase item"
        JLabel purchaseLabel = new JLabel("Purchase Item");
        purchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(purchaseLabel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Displaying Items");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.CENTER);

        // Table data and column headers
        String[] columnHeaders = {"Item No.", "Name", "Calories", "Price", "Quantity"};
        Object[][] tableData = new Object[uniqueItemList.size()][5];

        int itemNumber = 1;
        for (int i = 0; i < uniqueItemList.size(); i++) {
            Item item = uniqueItemList.get(i);
            tableData[i][0] = itemNumber;
            tableData[i][1] = item.getName();
            tableData[i][2] = item.getCalories();
            tableData[i][3] = item.getPrice();
            tableData[i][4] = countStock(item.getName());
            itemNumber++;
        }

        // Create the table with a default table model
        JTable table = new JTable(new DefaultTableModel(tableData, columnHeaders));

        // Limit table visibility to 6 rows and add a scrollbar
        int visibleRows = 6;
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(table.getPreferredSize().width, table.getRowHeight() * visibleRows));

        // 3. Adding vertical spacing between the drop-down and table
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Create a JComboBox with item names
        JComboBox<String> itemNamesComboBox = new JComboBox<>();
        // 2. Adding the first item on the drop-down as "Select an item you want to purchase"
        itemNamesComboBox.addItem("Select an item you want to purchase");
        for (Item item : uniqueItemList) {
            itemNamesComboBox.addItem(item.getName());
        }
        itemNamesComboBox.addActionListener(e -> {
            // TODO: Implement logic to handle item selection from the combo box
        });

        mainPanel.add(itemNamesComboBox, BorderLayout.NORTH);

        // Center align the text in all columns of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(e -> {
            String selectedItem = (String) itemNamesComboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.equals("Select an item you want to purchase")) {
                showPurchaseConfirmation(selectedItem);
            }
        });

        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> goBack());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(purchaseButton);
        bottomPanel.add(goBackButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }


    // You can implement the countStock method according to your requirements
    private int countStock(String itemName) {
        // Implement the logic to count stock for a specific item here
        return 0;
    }

    // Assuming you have the Item class with the required getters
    private static class Item {
        private final String name;
        private final int calories;
        private final double price;

        public Item(String name, int calories, double price) {
            this.name = name;
            this.calories = calories;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getCalories() {
            return calories;
        }

        public double getPrice() {
            return price;
        }
    }

    private void goBack() {
        // Implement the logic to go back to vending features here
        // For example, you can close this window and open the main vending window
        dispose();
    }

    private void showPurchaseConfirmation(String itemName) {
        JOptionPane.showMessageDialog(this, "You have bought " + itemName,
                "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        // Replace this with your actual list of items
        List<Item> uniqueItemList = new ArrayList<>();
        uniqueItemList.add(new Item("Item1", 100, 2.99));
        uniqueItemList.add(new Item("Item2", 150, 4.99));
        uniqueItemList.add(new Item("Item3", 200, 3.49));
        uniqueItemList.add(new Item("Item4", 100, 2.99));
        uniqueItemList.add(new Item("Item5", 150, 4.99));
        uniqueItemList.add(new Item("Item6", 200, 3.49));
        uniqueItemList.add(new Item("Item7", 100, 2.99));
        uniqueItemList.add(new Item("Item8", 150, 4.99));
        uniqueItemList.add(new Item("Item9", 200, 3.49));
        uniqueItemList.add(new Item("Item10", 100, 2.99));
        uniqueItemList.add(new Item("Item11", 150, 4.99));
        uniqueItemList.add(new Item("Item12", 200, 3.49));
        uniqueItemList.add(new Item("Item13", 100, 2.99));
        uniqueItemList.add(new Item("Item14", 150, 4.99));
        uniqueItemList.add(new Item("Item15", 200, 3.49));
        uniqueItemList.add(new Item("Item16", 100, 2.99));
        uniqueItemList.add(new Item("Item17", 150, 4.99));
        uniqueItemList.add(new Item("Item18", 200, 3.49));
        uniqueItemList.add(new Item("Item19", 100, 2.99));
        uniqueItemList.add(new Item("Item20", 150, 4.99));
        uniqueItemList.add(new Item("Item21", 200, 3.49));


        SwingUtilities.invokeLater(() -> new PurchaseGUI(uniqueItemList));
    }
}
