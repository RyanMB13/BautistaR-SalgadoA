import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineOptions extends JFrame {
    private JButton regularButton;
    private JButton specialButton;
    private JFrame optionsFrame;

    public VendingMachineOptions() {
        // Initialize the JFrame with a title
        super("Vending Machine Options");
        setLayout(new BorderLayout());
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        // Create a new JFrame for displaying the options
        optionsFrame = new JFrame("Vending Machine Options");
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

        // Add buttons to the panel
        optionsPanel.add(regularButton);
        optionsPanel.add(specialButton);

        // Add the options panel to the frame
        optionsFrame.add(optionsPanel, BorderLayout.CENTER);

        // Pack and set visible
        optionsFrame.pack();
        optionsFrame.setLocationRelativeTo(null);
        optionsFrame.setVisible(true);
    }

    public void SetActionListener(ActionListener listener) {
        regularButton.addActionListener(listener);
        specialButton.addActionListener(listener);
    }

    public void RegularSelectedDisplay(){
        JOptionPane.showMessageDialog(optionsFrame, "Regular Vending Machine selected!", "Vending Machine Options", JOptionPane.INFORMATION_MESSAGE);
        optionsFrame.dispose(); // Close the options frame after selection
        setVisible(false);
    }

    public void SpecialSelectedDisplay(){
        JOptionPane.showMessageDialog(optionsFrame, "Special Vending Machine selected!", "Vending Machine Options", JOptionPane.INFORMATION_MESSAGE);
        optionsFrame.dispose(); // Close the options frame after selection
        setVisible(false);
    }
}
