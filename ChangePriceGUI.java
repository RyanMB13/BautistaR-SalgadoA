import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangePriceGUI extends JFrame {

    private JFrame purchaseFrame;
    private JButton goBackButton;
    private JButton changePriceButton;
    private JTextField newPriceField;
    private JComboBox<String> itemNamesComboBox;
    private final java.util.List<Item> uniqueItemList;
    protected final ArrayList<String> outputList = new ArrayList<>();


    public ChangePriceGUI (java.util.List<Item> uniqueItemList) {
        super("Change Price");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.uniqueItemList = uniqueItemList;
    }

    public void init() {
        purchaseFrame = new JFrame("Change Price");
        purchaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        purchaseFrame.setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 1. Adding a label on the north center saying "Purchase item"
        JLabel purchaseLabel = new JLabel("Change Price");
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

        // Create a JComboBox with item names
        itemNamesComboBox = new JComboBox<>();
        // 2. Adding the first item on the drop-down as "Select an item you want to purchase"
        itemNamesComboBox.addItem("Select an item you want to change the price");
        for (Item item : uniqueItemList) {
            itemNamesComboBox.addItem(item.getName());
        }

        // Add an action listener to the JComboBox
        itemNamesComboBox.addActionListener(e -> {
            // Retrieve the selected index
            int selectedIndex = itemNamesComboBox.getSelectedIndex();
        });

        // 3. Adding vertical spacing between the drop-down and JSpinner
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(itemNamesComboBox, BorderLayout.NORTH);
        northPanel.add(Box.createVerticalStrut(5), BorderLayout.CENTER);

        // Create JTextField labeled "New Price"
        newPriceField = new JTextField(10);  // 10 columns wide
        JLabel newPriceLabel = new JLabel("New Price");
        newPriceLabel.setLabelFor(newPriceField);

        JPanel newPricePanel = new JPanel();
        newPricePanel.setLayout(new BorderLayout());
        newPricePanel.add(newPriceLabel, BorderLayout.NORTH);
        newPricePanel.add(newPriceField, BorderLayout.CENTER);

        // 4. Adding vertical spacing between the JTextField and table
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(newPricePanel, BorderLayout.NORTH);
        centerPanel.add(Box.createVerticalStrut(5), BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        northPanel.add(centerPanel, BorderLayout.SOUTH);
        mainPanel.add(northPanel, BorderLayout.CENTER);


        // Center align the text in all columns of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        changePriceButton = new JButton("Change Price");
        goBackButton = new JButton("Go Back");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(changePriceButton);
        bottomPanel.add(goBackButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }
    public void setActionListener(ActionListener listener){
        changePriceButton.addActionListener(listener);
        goBackButton.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener){
        newPriceField.getDocument().addDocumentListener(listener);
    }

    public String getNewPrice(){ return newPriceField.getText(); }
    public void showChangePriceMessage(String name) {
        StringBuilder message = new StringBuilder("Item: " + name + "\n"); //StringBuilder to build the message for the JOptionPane

        for (String s : outputList) {
            message.append(s);
        }

        JOptionPane.showMessageDialog(this, message, "Change Price", JOptionPane.INFORMATION_MESSAGE);
    }
    public int getSelectedIndex(){ return itemNamesComboBox.getSelectedIndex(); }

    public void Exit(){
        dispose();
    }
}


