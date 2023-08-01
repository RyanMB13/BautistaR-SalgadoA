import javax.swing.*;
import java.awt.*;

public class RegularMaintenanceFeatures extends JFrame {

    private JButton addItemButton;
    private JButton changePriceButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;

    public RegularMaintenanceFeatures() {
        // title
        super("Regular Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        showRegMaintenanceOptions(this);

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void showRegMaintenanceOptions(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame regMaintenanceOptionsFrame = new JFrame("Maintenance Features");
        regMaintenanceOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regMaintenanceOptionsFrame.setSize(300, 300);
        regMaintenanceOptionsFrame.setResizable(false);
        regMaintenanceOptionsFrame.setLayout(new BorderLayout());

        // Panel to hold the options with BoxLayout
        JPanel regMaintenanceOptionsPanel = new JPanel();
        regMaintenanceOptionsPanel.setLayout(new BoxLayout(regMaintenanceOptionsPanel, BoxLayout.Y_AXIS));
        regMaintenanceOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Regular Maintenance Features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        regMaintenanceOptionsPanel.add(titleLabel);

        // Buttons for the regular vending machine features
        addItemButton = new JButton("Add Item");
        changePriceButton = new JButton("Change Price");
        collectPaymentButton = new JButton("Collect Payment");
        replenishStockButton = new JButton("Replenish Stock");
        replenishChangeButton = new JButton("Replenish Change");
        printSummaryButton = new JButton("Print Purchase Summary");
        backButton = new JButton("Back to Test Menu");

        // Center align the buttons
        addItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectPaymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePriceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishChangeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printSummaryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        addItemButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Enter Money selected!");
        });
        collectPaymentButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Enter Money selected!");
        });
        changePriceButton.addActionListener(e -> {
            // TODO: Add code for "Change Price" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Display Items selected!");
        });

        replenishStockButton.addActionListener(e -> {
            // TODO: Add code for "Replenish Stock" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Purchase Item selected!");
        });

        replenishChangeButton.addActionListener(e -> {
            // TODO: Add code for "Replenish change" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Produce Change selected!");
        });

        printSummaryButton.addActionListener(e -> {
            // TODO: Add code for "Print summary" functionality
            JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, "Produce Change selected!");
        });

        backButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (TestFeaturesOptions) again
            regMaintenanceOptionsFrame.dispose();
        });

        // Add buttons to the panel
        regMaintenanceOptionsPanel.add(addItemButton);
        regMaintenanceOptionsPanel.add(collectPaymentButton);
        regMaintenanceOptionsPanel.add(changePriceButton);
        regMaintenanceOptionsPanel.add(replenishStockButton);
        regMaintenanceOptionsPanel.add(replenishChangeButton);
        regMaintenanceOptionsPanel.add(printSummaryButton);
        regMaintenanceOptionsPanel.add(backButton);

        // Add the options panel to the frame
        regMaintenanceOptionsFrame.add(regMaintenanceOptionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        regMaintenanceOptionsFrame.setLocationRelativeTo(parentFrame);
        regMaintenanceOptionsFrame.setVisible(true);
    }
}
