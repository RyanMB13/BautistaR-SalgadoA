import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ItemDisplayGUI extends JFrame{

    private JFrame displayFrame;
    private JButton goBackButton;
    private java.util.List<Item> uniqueItemList;
    public ItemDisplayGUI(java.util.List<Item> uniqueItemList){
        super("Display Itms");
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.uniqueItemList = uniqueItemList;

        init();
    }

    public void init() {
        displayFrame = new JFrame("Item Display");
        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayFrame.setSize(500, 400);
        displayFrame.setLocationRelativeTo(null);

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
        //goBackButton.addActionListener(e -> goBack());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(goBackButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        displayFrame.getContentPane().add(mainPanel);
        displayFrame.setVisible(true);
    }

    public void goBack() {
        // Implement the logic to go back to vending features here
        // For example, you can close this window and open the main vending window
        dispose();
    }
    public void setActionListener(ActionListener listener){
        goBackButton.addActionListener(listener);
    }

}
