import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegularMaintenanceFeatures extends JFrame {

    private JButton addItemButton;
    private JButton changePriceButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;
    private JFrame regMaintenanceOptionsFrame;

    protected ArrayList<String> outputList = new ArrayList<>();

    public RegularMaintenanceFeatures() {
        // title
        super("Regular Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void init() {
        // Create a new JFrame for displaying the options
        regMaintenanceOptionsFrame = new JFrame("Maintenance Features");
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
        regMaintenanceOptionsFrame.setLocationRelativeTo(null);
        regMaintenanceOptionsFrame.setVisible(true);
    }

    public void setActionListener(ActionListener listener) {
        addItemButton.addActionListener(listener);
        collectPaymentButton.addActionListener(listener);
        changePriceButton.addActionListener(listener);
        replenishStockButton.addActionListener(listener);
        replenishChangeButton.addActionListener(listener);
        printSummaryButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void Exit(){
        regMaintenanceOptionsFrame.dispose();
    }

    public void displayCollectPayment(double payment) {
        StringBuilder message = new StringBuilder("Payment to be dispensed: ₱" + payment + "\n"); //StringBuilder to build the message for the JOptionPane

        for (String s : outputList){
            message.append(s);
        }

        JOptionPane.showMessageDialog(regMaintenanceOptionsFrame, message, "Collect Payment", JOptionPane.INFORMATION_MESSAGE);
    }
}
