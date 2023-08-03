import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddItemGUI extends JFrame {
    private JTextField nameField;
    private JTextField priceField;
    private JTextField caloriesField;
    private JTextField stockField;

    private JButton addItemButton;


    public AddItemGUI() {
        super("Add Item");
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        JLabel priceLabel = new JLabel("Price:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(priceLabel, gbc);

        priceField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(priceField, gbc);

        JLabel caloriesLabel = new JLabel("Calories:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(caloriesLabel, gbc);

        caloriesField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(caloriesField, gbc);

        JLabel stockLabel = new JLabel("Stock:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(stockLabel, gbc);

        stockField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(stockField, gbc);

        addItemButton = new JButton("Add Item");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addItemButton, gbc);

        add(panel);
        setVisible(true);
    }

    public void setActionListener(ActionListener listener){
        addItemButton.addActionListener(listener);
    }
    public void displayAdd(String name, double price, int calories, int stock) {
        String message = "You have added:\n" +
                "\"" + name + "\"\n" +
                "Price: " + price + "\n" +
                "Calories: " + calories + "\n" +
                "Stock: " + stock;

        JOptionPane.showMessageDialog(null, message, "Item Added", JOptionPane.INFORMATION_MESSAGE);
    }
}