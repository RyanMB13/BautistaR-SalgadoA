import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegularVendingFeatures extends JFrame {

    private JButton enterMoneyButton;
    private JButton displayItemsButton;
    private JButton purchaseItemButton;
    private JButton produceChangeButton;
    private JButton backButton;
    private JFrame regFeaturesOptionsFrame;
    protected ArrayList<String> outputList = new ArrayList<>();

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
        regFeaturesOptionsFrame = new JFrame("Regular Vending Machine Features");
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
        public void setActionListener(ActionListener listener) {
            enterMoneyButton.addActionListener(listener);
            displayItemsButton.addActionListener(listener);
            purchaseItemButton.addActionListener(listener);
            produceChangeButton.addActionListener(listener);
            backButton.addActionListener(listener);
        }

        public void Exit(){
            regFeaturesOptionsFrame.dispose();
        }

        public void displayProduceChange(double change){
            StringBuilder message = new StringBuilder("Change to be dispensed: ₱" + change + "\n"); //StringBuilder to build the message for the JOptionPane

            for (String s : outputList){
                message.append(s);
            }

            JOptionPane.showMessageDialog(regFeaturesOptionsFrame, message, "Produce Change", JOptionPane.INFORMATION_MESSAGE);
        }
}


