import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecialMaintenanceFeatures extends JFrame {
    private JButton addItemButton ;
    private JButton changePriceButton ;
    private JButton cannotBeSoldButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;

    private JFrame specialMaintenanceOptionsFrame;

    protected ArrayList<String> outputList = new ArrayList<>();

    public SpecialMaintenanceFeatures() {
        // title
        super("Special Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init() {
        // Create a new JFrame for displaying the options
        specialMaintenanceOptionsFrame = new JFrame("Maintenance Features");
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
        specialMaintenanceOptionsFrame.setLocationRelativeTo(null);//keep it centered
        specialMaintenanceOptionsFrame.setVisible(true);
    }

    public void setActionListener(ActionListener listener) {
        addItemButton.addActionListener(listener);
        changePriceButton.addActionListener(listener);
        cannotBeSoldButton.addActionListener(listener);
        collectPaymentButton.addActionListener(listener);
        replenishStockButton.addActionListener(listener);
        replenishChangeButton.addActionListener(listener);
        printSummaryButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void Exit(){
        specialMaintenanceOptionsFrame.dispose();
    }

    public void displayCollectPayment(double payment) {
        StringBuilder message = new StringBuilder("Payment to be dispensed: ₱" + payment + "\n"); //StringBuilder to build the message for the JOptionPane

        for (String s : outputList){
            message.append(s);
        }

        JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, message, "Collect Payment", JOptionPane.INFORMATION_MESSAGE);
    }

}
