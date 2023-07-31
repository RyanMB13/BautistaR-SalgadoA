import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class VendingMachineGUI extends JFrame {
    private VendingMachineOptions vendingOptions;
    private JButton createButton;
    private JButton testButton;
    private JButton exitButton;

    public VendingMachineGUI() {
        // Set up the JFrame
        super("Vending Machine");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);

        setResizable(false);

        int padding = 20;

        // Welcome label at the top with padding
        JLabel welcomeLabel = new JLabel("Welcome to the Vending Machine");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        add(welcomeLabel, BorderLayout.NORTH);

        // Panel to hold the buttons with padding
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(0, padding, padding, padding));

        // Buttons for the main menu options
        createButton = new JButton("Create vending machine");
        testButton = new JButton("Test features");
        exitButton = new JButton("Exit");

        // Center align the buttons
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a single instance of VendingMachineOptions
        vendingOptions = new VendingMachineOptions();
        // Add action listeners to the buttons
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingOptions.vendingTypes(VendingMachineGUI.this);
                setVisible(false);
            }
        });

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the Test Features menu
                vendingOptions.testFeaturesOptions(VendingMachineGUI.this);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the program
                System.exit(0);
            }
        });

        // Add buttons to the panel
        buttonPanel.add(createButton);
        buttonPanel.add(testButton);
        buttonPanel.add(exitButton);

        // Add the button panel to the center of the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Pack and set visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

class VendingMachineOptions {

    boolean isRegularVendingMachine = true;
    private JButton regularButton;
    private JButton specialButton;
    private JButton vendingMachineButton;
    private JButton maintenanceButton;
    private JButton exitTestButton;
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
        JLabel titleLabel = new JLabel("Test features:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        testOptionsPanel.add(titleLabel);

        // Buttons for the test feature options
        vendingMachineButton = new JButton("Vending machine features");
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

class RegularVendingFeatures {
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

class SpecialVendingFeatures {
    private JButton enterMoneyButton;
    private JButton displayItemsButton;
    private JButton purchaseIndividualItemButton;
    private JButton purchaseRamenButton;
    private JButton produceChangeButton;
    private JButton backButton;

    private JLabel cashTrackerLabel;

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
        cashTrackerLabel = new JLabel();
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

class RegularMaintenanceFeatures {
    private JButton addItemButton;
    private JButton changePriceButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;
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

class SpecialMaintenanceFeatures {
    private JButton addItemButton ;
    private JButton changePriceButton ;
    private JButton cannotBeSoldButton;
    private JButton collectPaymentButton;
    private JButton replenishStockButton;
    private JButton replenishChangeButton;
    private JButton printSummaryButton;
    private JButton backButton;
    public void showSpecialMaintenanceOptions(JFrame parentFrame) {
        // Create a new JFrame for displaying the options
        JFrame specialMaintenanceOptionsFrame = new JFrame("Maintenance Features");
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

        // Add action listeners to the buttons
        addItemButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
        collectPaymentButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
       cannotBeSoldButton.addActionListener(e -> {
            // TODO: Add code for "add Item" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Enter Money selected!");
        });
        changePriceButton.addActionListener(e -> {
            // TODO: Add code for "Change Price" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Display Items selected!");
        });

        replenishStockButton.addActionListener(e -> {
            // TODO: Add code for "Replenish Stock" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Purchase Item selected!");
        });

        replenishChangeButton.addActionListener(e -> {
            // TODO: Add code for "Replenish change" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Produce Change selected!");
        });

        printSummaryButton.addActionListener(e -> {
            // TODO: Add code for "Print summary" functionality
            JOptionPane.showMessageDialog(specialMaintenanceOptionsFrame, "Produce Change selected!");
        });

        backButton.addActionListener(e -> {
            // Close the options frame and show the parent frame (TestFeaturesOptions) again
            specialMaintenanceOptionsFrame.dispose();
        });

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
        specialMaintenanceOptionsFrame.setLocationRelativeTo(parentFrame);
        specialMaintenanceOptionsFrame.setVisible(true);
    }
}