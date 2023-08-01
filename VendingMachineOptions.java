import javax.swing.*;
import java.awt.*;

public class VendingMachineOptions extends JFrame {

    boolean isRegularVendingMachine = true;
    private JButton regularButton;
    private JButton specialButton;
    private JButton vendingMachineButton;
    private JButton maintenanceButton;
    private JButton exitTestButton;

    public VendingMachineOptions() {
        // Initialize the JFrame with a title
        super("Vending Machine Options");
        setLayout(new BorderLayout());

        setSize(300, 200);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void vendingTypes(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame optionsFrame = new JFrame("Vending Machine Options");
        optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        optionsFrame.setSize(300, 200);
        optionsFrame.setLayout(new BorderLayout());
        optionsFrame.setResizable(false);

        // Panel to hold the options with BoxLayout
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Choose your vending machine type:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsPanel.add(titleLabel);

        // Buttons for the vending machine types
        regularButton = new JButton("Regular Vending Machine");
        specialButton = new JButton("Special Vending Machine");

        // Center align the buttons
        regularButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        regularButton.addActionListener(e -> {
            // TODO: Add code for "Regular Vending Machine" functionality
            JOptionPane.showMessageDialog(optionsFrame, "Regular Vending Machine selected!");
            optionsFrame.dispose(); // Close the options frame after selection
            parentFrame.setVisible(true); // Show the main menu frame again
            isRegularVendingMachine = true;
        });

        specialButton.addActionListener(e -> {
            // TODO: Add code for "Special Vending Machine" functionality
            JOptionPane.showMessageDialog(optionsFrame, "Special Vending Machine selected!");
            optionsFrame.dispose(); // Close the options frame after selection
            parentFrame.setVisible(true); // Show the main menu frame again
            isRegularVendingMachine = false;
        });

        // Add buttons to the panel
        optionsPanel.add(regularButton);
        optionsPanel.add(specialButton);

        // Add the options panel to the frame
        optionsFrame.add(optionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        optionsFrame.pack();
        optionsFrame.setLocationRelativeTo(parentFrame);
        optionsFrame.setVisible(true);
    }
    public void testFeaturesOptions(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame testOptionsFrame = new JFrame("Test Features");
        testOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        testOptionsFrame.setSize(250, 200);
        testOptionsFrame.setResizable(false);
        testOptionsFrame.setLayout(new BorderLayout());

        // Panel to hold the options with BoxLayout
        JPanel testOptionsPanel = new JPanel();
        testOptionsPanel.setLayout(new BoxLayout(testOptionsPanel, BoxLayout.Y_AXIS));
        testOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Test Features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        testOptionsPanel.add(titleLabel);

        // Buttons for the test feature options
        vendingMachineButton = new JButton("Vending Machine Features");
        maintenanceButton = new JButton("Maintenance Features");
        exitTestButton = new JButton("Exit");

        // Center align the buttons
        vendingMachineButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        maintenanceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitTestButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        vendingMachineButton.addActionListener(e -> {
            // Hide the parent frame (TestFeaturesOptions) and call the appropriate method
            // based on the vending machine type (Regular or Special)
            parentFrame.setVisible(false);

            // Call the appropriate method based on the vending machine type
            if (isRegularVendingMachine) {
                RegularVendingFeatures features = new RegularVendingFeatures();
                features.showRegFeatureOptions(parentFrame);
            } else {
                SpecialVendingFeatures features = new SpecialVendingFeatures();
                features.showSpecialFeaturesOptions(parentFrame);
            }
        });

        maintenanceButton.addActionListener(e -> {
            // Hide the parent frame (TestFeaturesOptions) and call the appropriate method
            // based on the vending machine type (Regular or Special)
            parentFrame.setVisible(false);

            // Call the appropriate method based on the vending machine type
            if (isRegularVendingMachine) {
                RegularMaintenanceFeatures features = new RegularMaintenanceFeatures();
                features.showRegMaintenanceOptions(parentFrame);
            } else {
                SpecialMaintenanceFeatures features = new SpecialMaintenanceFeatures();
                features.showSpecialMaintenanceOptions(parentFrame);
            }
        });

        exitTestButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (main menu) again
            testOptionsFrame.dispose();
            parentFrame.setVisible(true);
        });

        // Add buttons to the panel
        testOptionsPanel.add(vendingMachineButton);
        testOptionsPanel.add(maintenanceButton);
        testOptionsPanel.add(exitTestButton);

        // Add the options panel to the frame
        testOptionsFrame.add(testOptionsPanel, BorderLayout.CENTER);

        // set visible
        testOptionsFrame.setLocationRelativeTo(parentFrame);
        testOptionsFrame.setVisible(true);
    }
}
