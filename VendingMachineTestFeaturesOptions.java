import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineTestFeaturesOptions extends JFrame {
    private JButton vendingMachineButton;
    private JButton maintenanceButton;
    private JButton exitTestButton;

    public VendingMachineTestFeaturesOptions() {
        // Initialize the JFrame with a title
        super("Test Features");
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
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
                features.init();
            } else {
                SpecialVendingFeatures features = new SpecialVendingFeatures();
                features.init();
            }
        });

        maintenanceButton.addActionListener(e -> {
            // Hide the parent frame (TestFeaturesOptions) and call the appropriate method
            // based on the vending machine type (Regular or Special)
            parentFrame.setVisible(false);

            // Call the appropriate method based on the vending machine type
            if (isRegularVendingMachine) {
                RegularMaintenanceFeatures features = new RegularMaintenanceFeatures();
                features.init();
            } else {
                SpecialMaintenanceFeatures features = new SpecialMaintenanceFeatures();
                features.init();
            }
        });

        exitTestButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (main menu) again
            testOptionsFrame.dispose();
        });

        // Add buttons to the panel
        testOptionsPanel.add(vendingMachineButton);
        testOptionsPanel.add(maintenanceButton);
        testOptionsPanel.add(exitTestButton);

        // Add the options panel to the frame
        testOptionsFrame.add(testOptionsPanel, BorderLayout.CENTER);

        // set visible
        //testOptionsFrame.setLocationRelativeTo(parentFrame);
        testOptionsFrame.setVisible(true);
    }

    public void SetActionListener(ActionListener listener){
        vendingMachineButton.addActionListener(listener);
        maintenanceButton.addActionListener(listener);
        exitTestButton.addActionListener(listener);
    }
}
