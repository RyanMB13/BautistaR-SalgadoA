import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDisplayGUI extends JFrame {

    private final List<Item> uniqueItemList;

    public ItemDisplayGUI(List<Item> uniqueItemList) {
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

        JLabel titleLabel = new JLabel("Displaying Items");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

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

        JTable table = new JTable(new DefaultTableModel(tableData, columnHeaders));

        // Center align the text in all columns of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton goBackButton = new JButton("Go Back to Vending Features");
        goBackButton.addActionListener(e -> goBack());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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

    public static void main(String[] args) {
        // Replace this with your actual list of items
        List<Item> uniqueItemList = new ArrayList<>();
        uniqueItemList.add(new Item("Item1", 100, 2.99));
        uniqueItemList.add(new Item("Item2", 150, 4.99));
        uniqueItemList.add(new Item("Item3", 200, 3.49));

        SwingUtilities.invokeLater(() -> new ItemDisplayGUI(uniqueItemList));
    }
}
