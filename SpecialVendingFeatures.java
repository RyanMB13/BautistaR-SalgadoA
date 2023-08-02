import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialVendingFeatures extends JFrame {

    private JButton enterMoneyButton;
    private JButton displayItemsButton;
    private JButton purchaseIndividualItemButton;
    private JButton purchaseRamenButton;
    private JButton produceChangeButton;
    private JButton backButton;

    private JButton btn1000;
    private JButton btn500;
    private JButton btn200;
    private JButton btn100;
    private JButton btn50;
    private JButton btn20;
    private JButton btn10;
    private JButton btn5;
    private JButton btn1;
    private JButton btnDone;

    private JLabel cashTrackerLabel;

    public SpecialVendingFeatures() {
        // title
        super("Special Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        // Create a new JFrame for displaying the options
        JFrame specialFeaturesOptionsFrame = new JFrame("Special Vending Machine Features");
        specialFeaturesOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        specialFeaturesOptionsFrame.setSize(300, 300);
        specialFeaturesOptionsFrame.setResizable(false);
        specialFeaturesOptionsFrame.setLayout(new BorderLayout());

        // Panel to hold the options with BoxLayout
        JPanel specialFeaturesOptionsPanel = new JPanel();
        specialFeaturesOptionsPanel.setLayout(new BoxLayout(specialFeaturesOptionsPanel, BoxLayout.Y_AXIS));
        specialFeaturesOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Special Vending Machine Features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialFeaturesOptionsPanel.add(titleLabel);

        // Buttons for the special vending machine features
        enterMoneyButton = new JButton("Enter Money");
        displayItemsButton = new JButton("Display Items");
        purchaseIndividualItemButton = new JButton("Purchase Individual Item");
        purchaseRamenButton = new JButton("Purchase Ramen");
        produceChangeButton = new JButton("Produce Change");
        backButton = new JButton("Back to Test Menu");

        // Center align the buttons
        enterMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayItemsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchaseIndividualItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchaseRamenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        produceChangeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        enterMoneyButton.addActionListener(e -> {
            // TODO: Add code for "Enter Money" functionality
            SpecialVendingFeatures enterMoney = new SpecialVendingFeatures();
            enterMoney.enterMoney();
        });

        displayItemsButton.addActionListener(e -> {
            // TODO: Add code for "Display Items" functionality
            JOptionPane.showMessageDialog(specialFeaturesOptionsFrame, "Display Items selected!");
        });

        purchaseIndividualItemButton.addActionListener(e -> {
            // TODO: Add code for "Purchase Individual Item" functionality
            JOptionPane.showMessageDialog(specialFeaturesOptionsFrame, "Purchase Individual Item selected!");
        });

        purchaseRamenButton.addActionListener(e -> {
            // TODO: Add code for "Purchase Ramen" functionality
            JOptionPane.showMessageDialog(specialFeaturesOptionsFrame, "Purchase Ramen selected!");
        });

        produceChangeButton.addActionListener(e -> {
            // TODO: Add code for "Produce Change" functionality
            JOptionPane.showMessageDialog(specialFeaturesOptionsFrame, "Produce Change selected!");
        });

        backButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (TestFeaturesOptions) again
            specialFeaturesOptionsFrame.dispose();
        });

        // Add buttons to the panel
        specialFeaturesOptionsPanel.add(enterMoneyButton);
        specialFeaturesOptionsPanel.add(displayItemsButton);
        specialFeaturesOptionsPanel.add(purchaseIndividualItemButton);
        specialFeaturesOptionsPanel.add(purchaseRamenButton);
        specialFeaturesOptionsPanel.add(produceChangeButton);
        specialFeaturesOptionsPanel.add(backButton);

        // Add the options panel to the frame
        specialFeaturesOptionsFrame.add(specialFeaturesOptionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        specialFeaturesOptionsFrame.setLocationRelativeTo(null);
        specialFeaturesOptionsFrame.setVisible(true);
    }
}