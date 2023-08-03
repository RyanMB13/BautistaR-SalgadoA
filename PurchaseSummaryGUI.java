import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PurchaseSummaryGUI extends JFrame {

    private final List<Item> uniqueItemList;
    private int totalQuantitySold;
    private int totalSales;
    private JButton goBackButton;


    public PurchaseSummaryGUI(List<Item> uniqueItemList, int totalQuantitySold, int totalSales) {
        super("Purchase Summary");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.uniqueItemList = uniqueItemList;
        this.totalQuantitySold = totalQuantitySold;
        this.totalSales = totalSales;
    }

    public void init() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Labels for total quantity sold and total sales
        JLabel quantitySoldLabel = new JLabel("Quantity sold: " + totalQuantitySold);
        JLabel totalSalesLabel = new JLabel("Total sales: " + totalSales);
        panel.add(quantitySoldLabel);
        panel.add(Box.createRigidArea(new Dimension(15, 0))); // Spacer
        panel.add(totalSalesLabel);

        // Add the panel to the main panel
        add(panel, BorderLayout.NORTH);

        // Table data and column headers
        String[] columnHeaders = {"Name", "Initial Stock", "End Stock"};
        Object[][] tableData = new Object[uniqueItemList.size()][3];

        for (int i = 0; i < uniqueItemList.size(); i++) {
            Item item = uniqueItemList.get(i);
            tableData[i][0] = item.getName();
            tableData[i][1] = item.getInitialStock();
            tableData[i][2] = item.getEndStock();
        }

        JTable table = new JTable(new DefaultTableModel(tableData, columnHeaders));

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(table.getPreferredSize().width, table.getRowHeight()));

        // Adding vertical spacing between the labels and table
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Center align the text in all columns of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        goBackButton = new JButton("Go Back");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(goBackButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    public void Exit() {
        dispose();
    }

    public void setActionListener(ActionListener listener){
        goBackButton.addActionListener(listener);
    }
}

