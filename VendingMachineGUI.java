import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;


public class VendingMachineGUI extends JFrame {
    private boolean VMCreated = false;
    private final JButton createButton;
    private final JButton testButton;
    private final JButton exitButton;


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
        createButton = new JButton("Create Vending Machine");
        testButton = new JButton("Test Features");
        exitButton = new JButton("Exit");

        // Center align the buttons
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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

    public void setActionListener(ActionListener listener){
        createButton.addActionListener(listener);
        testButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public void setVMCreated(boolean created){
        this.VMCreated = created;
    }
    public boolean getVMCreated(){ return this.VMCreated; }
}