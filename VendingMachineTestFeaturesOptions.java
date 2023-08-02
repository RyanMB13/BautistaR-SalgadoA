import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineTestFeaturesOptions extends JFrame {
    private boolean isRegularVM;
    private JButton vendingMachineButton;
    private JButton maintenanceButton;
    private JButton exitTestButton;

    private JFrame testOptionsFrame;

    public VendingMachineTestFeaturesOptions(boolean isRegularVM) {
        // Initialize the JFrame with a title
        super("Test Features");
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.isRegularVM = isRegularVM;
    }

    public void init(){
        testOptionsFrame = new JFrame("Test Features");
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

        // Add buttons to the panel
        testOptionsPanel.add(vendingMachineButton);
        testOptionsPanel.add(maintenanceButton);
        testOptionsPanel.add(exitTestButton);

        // Add the options panel to the frame
        testOptionsFrame.add(testOptionsPanel, BorderLayout.CENTER);

        // set visible
        testOptionsFrame.setVisible(true);
    }

    public void SetActionListener(ActionListener listener){
        vendingMachineButton.addActionListener(listener);
        maintenanceButton.addActionListener(listener);
        exitTestButton.addActionListener(listener);
    }

    public boolean getIsRegularVM(){ return this.isRegularVM; }

    public void exitButton(){
        testOptionsFrame.dispose();
    }

    public void hideParentFrame(){
        setVisible(false);
    }
}
