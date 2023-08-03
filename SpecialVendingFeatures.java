import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecialVendingFeatures extends JFrame {

    private JButton enterMoneyButton;
    private JButton displayItemsButton;
    private JButton purchaseIndividualItemButton;
    private JButton purchaseRamenButton;
    private JButton produceChangeButton;
    private JButton backButton;
    private JFrame specialFeaturesOptionsFrame;

    protected ArrayList<String> outputList = new ArrayList<>();

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
        specialFeaturesOptionsFrame = new JFrame("Special Vending Machine Features");
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

    public void setActionListener (ActionListener listener) {
        enterMoneyButton.addActionListener(listener);
        displayItemsButton.addActionListener(listener);
        purchaseIndividualItemButton.addActionListener(listener);
        purchaseRamenButton.addActionListener(listener);
        produceChangeButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void Exit(){
        specialFeaturesOptionsFrame.dispose();
    }

    public void displayProduceChange(double change){
        StringBuilder message = new StringBuilder("Change to be dispensed: ₱" + change + "\n"); //StringBuilder to build the message for the JOptionPane

        for (String s : outputList){
            message.append(s);
        }

        JOptionPane.showMessageDialog(specialFeaturesOptionsFrame, message, "Produce Change", JOptionPane.INFORMATION_MESSAGE);
    }


}

