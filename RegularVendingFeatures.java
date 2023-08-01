import javax.swing.*;
import java.awt.*;

public class RegularVendingFeatures extends JFrame {

    private JButton enterMoneyButton;
    private JButton displayItemsButton;
    private JButton purchaseItemButton;
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



    public void showRegFeatureOptions(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame regFeaturesOptionsFrame = new JFrame("Regular Vending Machine Features");
        regFeaturesOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regFeaturesOptionsFrame.setSize(300, 300);
        regFeaturesOptionsFrame.setResizable(false);
        regFeaturesOptionsFrame.setLayout(new BorderLayout());

        // Panel to hold the options with BoxLayout
        JPanel regFeaturesOptionsPanel = new JPanel();
        regFeaturesOptionsPanel.setLayout(new BoxLayout(regFeaturesOptionsPanel, BoxLayout.Y_AXIS));
        regFeaturesOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the title
        JLabel titleLabel = new JLabel("Regular Vending Machine Features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        regFeaturesOptionsPanel.add(titleLabel);

        // Buttons for the regular vending machine features
        enterMoneyButton = new JButton("Enter Money");
        displayItemsButton = new JButton("Display Items");
        purchaseItemButton = new JButton("Purchase Item");
        produceChangeButton = new JButton("Produce Change");
        backButton = new JButton("Back to Test Menu");

        // Center align the buttons
        enterMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayItemsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchaseItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        produceChangeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        enterMoneyButton.addActionListener(e -> {
            // TODO: Add code for "Enter Money" functionality
            RegularVendingFeatures enterMoney = new RegularVendingFeatures();
            enterMoney.enterMoney(parentFrame);
        });

        displayItemsButton.addActionListener(e -> {
            // TODO: Add code for "Display Items" functionality
            JOptionPane.showMessageDialog(regFeaturesOptionsFrame, "Display Items selected!");
        });

        purchaseItemButton.addActionListener(e -> {
            // TODO: Add code for "Purchase Item" functionality
            JOptionPane.showMessageDialog(regFeaturesOptionsFrame, "Purchase Item selected!");
        });

        produceChangeButton.addActionListener(e -> {
            // TODO: Add code for "Produce Change" functionality
            JOptionPane.showMessageDialog(regFeaturesOptionsFrame, "Produce Change selected!");
        });

        backButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (TestFeaturesOptions) again
            regFeaturesOptionsFrame.dispose();
        });

        // Add buttons to the panel
        regFeaturesOptionsPanel.add(enterMoneyButton);
        regFeaturesOptionsPanel.add(displayItemsButton);
        regFeaturesOptionsPanel.add(purchaseItemButton);
        regFeaturesOptionsPanel.add(produceChangeButton);
        regFeaturesOptionsPanel.add(backButton);

        // Add the options panel to the frame
        regFeaturesOptionsFrame.add(regFeaturesOptionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        regFeaturesOptionsFrame.pack();
        regFeaturesOptionsFrame.setLocationRelativeTo(parentFrame);
        regFeaturesOptionsFrame.setVisible(true);
    }

    public void enterMoney(JFrame parentFrame) {
        JFrame enterMoneyFrame = new JFrame("Enter Money");
        enterMoneyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        enterMoneyFrame.setSize(400, 500);
        enterMoneyFrame.setResizable(false);
        enterMoneyFrame.setLayout(new BorderLayout());

        // Outermost Panel
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());

        // Middle Panel for the number buttons
        JPanel enterMoneyButtonPanel = new JPanel();
        enterMoneyButtonPanel.setLayout(new GridLayout(3, 3, 10, 10)); // 3 rows, 3 columns, and spacing between buttons
        enterMoneyButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // North Panel for the label
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("How much money do you want to enter?");
        labelPanel.add(titleLabel);

        // Inner Panel for the Finish button and current cash tracker
        JPanel finishPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cashTrackerLabel = new JLabel("Current Cash: ₱");
        finishPanel.add(cashTrackerLabel);
        JButton btnDone = new JButton("Finish Adding Money");
        finishPanel.add(btnDone);

        // Buttons each denomination
        JButton btn1000 = new JButton("1000");
        JButton btn500 = new JButton("500");
        JButton btn200 = new JButton("200");
        JButton btn100 = new JButton("100");
        JButton btn50 = new JButton("50");
        JButton btn20 = new JButton("20");
        JButton btn10 = new JButton("10");
        JButton btn5 = new JButton("5");
        JButton btn1 = new JButton("1");

        // Action listeners
        btn1000.addActionListener(e -> {
            // TODO: Add code for "1000" functionality
        });

        btn500.addActionListener(e -> {
            // TODO: Add code for "500" functionality
        });

        btn200.addActionListener(e -> {
            // TODO: Add code for "200" functionality
        });

        btn100.addActionListener(e -> {
            // TODO: Add code for "100" functionality
        });

        btn50.addActionListener(e -> {
            // TODO: Add code for "50" functionality
        });

        btn20.addActionListener(e -> {
            // TODO: Add code for "20" functionality
        });

        btn10.addActionListener(e -> {
            // TODO: Add code for "10" functionality
        });
        btn5.addActionListener(e -> {
            // TODO: Add code for "5" functionality
        });

        btn1.addActionListener(e -> {
            // TODO: Add code for "1" functionality
        });

        btnDone.addActionListener(e -> {
            // TODO: Add code for "Done" functionality
            JOptionPane.showMessageDialog(enterMoneyFrame, "You have entered P + current cash");
            enterMoneyFrame.dispose();
        });

        // Add buttons to the panel with 3 buttons per row
        enterMoneyButtonPanel.add(btn1000);
        enterMoneyButtonPanel.add(btn500);
        enterMoneyButtonPanel.add(btn200);
        enterMoneyButtonPanel.add(btn100);
        enterMoneyButtonPanel.add(btn50);
        enterMoneyButtonPanel.add(btn20);
        enterMoneyButtonPanel.add(btn10);
        enterMoneyButtonPanel.add(btn5);
        enterMoneyButtonPanel.add(btn1);

        // Add the components to the panels and the frame
        enterMoneyFrame.add(labelPanel, BorderLayout.NORTH);
        enterMoneyFrame.add(enterMoneyButtonPanel, BorderLayout.CENTER);
        enterMoneyFrame.add(finishPanel, BorderLayout.SOUTH);

        // Pack and set visible
        enterMoneyFrame.setLocationRelativeTo(parentFrame);
        enterMoneyFrame.setVisible(true);
    }

    public void setUserCash(double userCash){
        // Sets the text at the bottom of Enter Money to whatever the userCash is.
        cashTrackerLabel.setText("Current Cash: ₱" + userCash);
    }
}
