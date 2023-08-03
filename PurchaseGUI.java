import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PurchaseGUI extends JFrame {

    private JFrame purchaseFrame;

    private JButton goBackButton;
    private JButton purchaseButton;

    private JTable table;
    private JComboBox<String> itemNamesComboBox;
    private java.util.List<Item> uniqueItemList;

    public PurchaseGUI(java.util.List<Item> uniqueItemList) {
        super("Purchase Items");
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.uniqueItemList = uniqueItemList;
    }

    public void init() {
        purchaseFrame = new JFrame("Purchase Item");
        purchaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        purchaseFrame.setSize(500, 400);

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
            //tableData[i][4] = countStock(item.getName());
            itemNumber++;
        }

        // Create the table with a default table model
        table = new JTable(new DefaultTableModel(tableData, columnHeaders));

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
        itemNamesComboBox = new JComboBox<>();
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

        purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(e -> {
            String selectedItem = (String) itemNamesComboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.equals("Select an item you want to purchase")) {
                showPurchaseConfirmation(selectedItem);
            }
        });

        goBackButton = new JButton("Go Back");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(purchaseButton);
        bottomPanel.add(goBackButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private void Exit() {
        purchaseFrame.dispose();
    }

    private void showPurchaseConfirmation(String itemName) {
        JOptionPane.showMessageDialog(this, "You have bought " + itemName,
                "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setActionListener(ActionListener listener){
        purchaseButton.addActionListener(listener);
        goBackButton.addActionListener(listener);
    }

}

