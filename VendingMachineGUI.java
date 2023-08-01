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