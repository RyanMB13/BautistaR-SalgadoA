import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
    private JLabel cashTracker;

    public RegularVendingFeatures() {
        // title
        super("Regular Vending Machine Features");
        setLayout(new BorderLayout());

        setSize(300, 300);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void init() {
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
        JButton enterMoneyButton = new JButton("Enter Money");
        JButton displayItemsButton = new JButton("Display Items");
        JButton purchaseItemButton = new JButton("Purchase Item");
        JButton produceChangeButton = new JButton("Produce Change");
        JButton backButton = new JButton("Back to Test Menu");

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
            enterMoney.enterMoney(regFeaturesOptionsFrame);
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
        regFeaturesOptionsFrame.setLocationRelativeTo(null); // Center on screen
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
        setUserCash(1500);
        //finishPanel.add(cashTrackerLabel);
        cashTracker = new JLabel("Current cash:" + cashTrackerLabel.getText());
        JButton btnDone = new JButton("Finish Adding Money");
        finishPanel.add(cashTracker);
        finishPanel.add(btnDone);

        // Buttons for each denomination
        btn1000 = new JButton("1000");
        btn500 = new JButton("500");
        btn200 = new JButton("200");
        btn100 = new JButton("100");
        btn50 = new JButton("50");
        btn20 = new JButton("20");
        btn10 = new JButton("10");
        btn5 = new JButton("5");
        btn1 = new JButton("1");

        btnDone.addActionListener(e -> {
            // TODO: Add code for "Done" functionality
            JOptionPane.showMessageDialog(enterMoneyFrame, "You have entered P"+cashTrackerLabel.getText());
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
            cashTrackerLabel.setText(String.valueOf(userCash));
    }

    public void setActionListener (ActionListener listener){
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
