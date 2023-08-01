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
        showSpecialFeaturesOptions(this);

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

        public void showSpecialFeaturesOptions(JFrame parentFrame) {
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
            enterMoney.enterMoney(parentFrame);
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
        specialFeaturesOptionsFrame.setLocationRelativeTo(parentFrame);
        specialFeaturesOptionsFrame.setVisible(true);
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
        setUserCash(10000);
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
        cashTrackerLabel = new JLabel();
        cashTrackerLabel.setText("Current Cash: ₱" + userCash);
    }

    public void setActionListener (ActionListener listener){
        btn1000 = new JButton("1000");
        btn500 = new JButton("500");
        btn200 = new JButton("200");
        btn100 = new JButton("100");
        btn50 = new JButton("50");
        btn20 = new JButton("20");
        btn10 = new JButton("10");
        btn5 = new JButton("5");
        btn1 = new JButton("1");

        // Action listeners
        btn1000.addActionListener(listener);
        btn500.addActionListener(listener);
        btn200.addActionListener(listener);
        btn100.addActionListener(listener);
        btn50.addActionListener(listener);
        btn20.addActionListener(listener);
        btn10.addActionListener(listener);
        btn5.addActionListener(listener);
        btn1.addActionListener(listener);

    }
}

