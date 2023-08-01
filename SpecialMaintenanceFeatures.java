import javax.swing.*;
import java.awt.*;

public class SpecialMaintenanceFeatures extends JFrame {
    private JButton addItemButton ;
    private JButton changePriceButton ;
    private JButton cannotBeSoldButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;

    public SpecialMaintenanceFeatures() {
        // title
        super("Special Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void showSpecialMaintenanceOptions(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame specialMaintenanceOptionsFrame = new JFrame("Maintenance Features");
        specialMaintenanceOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        specialMaintenanceOptionsFrame.setSize(300, 300);
        specialMaintenanceOptionsFrame.setResizable(false);
        specialMaintenanceOptionsFrame.setLayout(new BorderLayout());

        // Panel to hold the options with BoxLayout
        JPanel specialMaintenanceOptionsPanel = new JPanel();
        specialMaintenanceOptionsPanel.setLayout(new BoxLayout(specialMaintenanceOptionsPanel, BoxLayout.Y_AXIS));
        specialMaintenanceOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Special Maintenance Features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialMaintenanceOptionsPanel.add(titleLabel);

        // Buttons for the regular vending machine features
        addItemButton = new JButton("Add Item");
        changePriceButton = new JButton("Change Price");
        cannotBeSoldButton = new JButton("Add to Cannot Be Sold Separately");
        collectPaymentButton = new JButton("Collect Payment");
        replenishStockButton = new JButton("Replenish Stock");
        replenishChangeButton = new JButton("Replenish Change");
        printSummaryButton = new JButton("Print Purchase Summary");
        backButton = new JButton("Back to Test Menu");

        // Center align the buttons
        addItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectPaymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cannotBeSoldButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePriceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishChangeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printSummaryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        addItemButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
        collectPaymentButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
        cannotBeSoldButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
        changePriceButton.addActionListener(e -> {
            // TODO: Add code for "Change Price" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Display Items selected!");
        });

        replenishStockButton.addActionListener(e -> {
            // TODO: Add code for "Replenish Stock" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Purchase Item selected!");
        });

        replenishChangeButton.addActionListener(e -> {
            // TODO: Add code for "Replenish change" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Produce Change selected!");
        });

        printSummaryButton.addActionListener(e -> {
            // TODO: Add code for "Print summary" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Produce Change selected!");
        });

        backButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (TestFeaturesOptions) again
            specialMaintenanceOptionsFrame.dispose();
        });

        // Add buttons to the panel
        specialMaintenanceOptionsPanel.add(addItemButton);
        specialMaintenanceOptionsPanel.add(collectPaymentButton);
        specialMaintenanceOptionsPanel.add(cannotBeSoldButton);
        specialMaintenanceOptionsPanel.add(changePriceButton);
        specialMaintenanceOptionsPanel.add(replenishStockButton);
        specialMaintenanceOptionsPanel.add(replenishChangeButton);
        specialMaintenanceOptionsPanel.add(printSummaryButton);
        specialMaintenanceOptionsPanel.add(backButton);

        // Add the options panel to the frame
        specialMaintenanceOptionsFrame.add(specialMaintenanceOptionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        specialMaintenanceOptionsFrame.setLocationRelativeTo(parentFrame);
        specialMaintenanceOptionsFrame.setVisible(true);
    }
}
