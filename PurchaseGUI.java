import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PurchaseGUI extends JFrame {

    private JFrame purchaseFrame;
    private JButton goBackButton;
    private JButton purchaseButton;
    private JComboBox<String> itemNamesComboBox;
    private final java.util.List<Item> uniqueItemList;

    private String selectedItem;

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
            tableData[i][4] = item.getStock();
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
        itemNamesComboBox = new JComboBox<>();
        // 2. Adding the first item on the drop-down as "Select an item you want to purchase"
        itemNamesComboBox.addItem("Select an item you want to purchase");
        for (Item item : uniqueItemList) {
            itemNamesComboBox.addItem(item.getName());
        }

        mainPanel.add(itemNamesComboBox, BorderLayout.NORTH);

        // Center align the text in all columns of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        purchaseButton = new JButton("Purchase");

        setSelectedItem((String) itemNamesComboBox.getSelectedItem());

        goBackButton = new JButton("Go Back");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(purchaseButton);
        bottomPanel.add(goBackButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public void setSelectedItem(String name) {
        this.selectedItem = name;
    }

    public String getItemName() {
        return this.selectedItem;
    }

    public void showPurchaseConfirmation(String itemName) {
        JOptionPane.showMessageDialog(this, "You have bought " + itemName,
                "Purchase Item", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showNotEnoughChangeMessage() {
        JOptionPane.showMessageDialog(this,"Cannot continue transaction due to insufficient change, " +
                "please ask the owner to replenish all denominations of change.",
                "Purchase Item", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showNotEnoughCashMessage() {
        JOptionPane.showMessageDialog(this,"You cannot afford this item!", "Purchase Item", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showNotEnoughStockMessage() {
        JOptionPane.showMessageDialog(this,"This item is sold out!", "Purchase Item", JOptionPane.INFORMATION_MESSAGE);
    }

   public void Exit() {
       purchaseFrame.dispose();
   }

    public void setActionListener(ActionListener listener){
        itemNamesComboBox.addActionListener(listener);
        purchaseButton.addActionListener(listener);
        goBackButton.addActionListener(listener);
    }



}

