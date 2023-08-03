import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterMoneyGUI extends JFrame {
    private JLabel cashTrackerLabel;
    private JButton btn1000;
    private JButton btn500;
    private JButton btn200;
    private JButton btn100;
    private JButton btn50;
    private JButton btn20;
    private JButton btn10;
    private JButton btn5;
    private JButton btn1;

    public EnterMoneyGUI() {
        // title
        super("Enter Money");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
    }

    public void init() {
        setSize(400, 500);

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
        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code for "Done" functionality
                JOptionPane.showMessageDialog(EnterMoneyGUI.this, "You have entered P "+cashTrackerLabel.getText());
                dispose();
            }
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
        add(labelPanel, BorderLayout.NORTH);
        add(enterMoneyButtonPanel, BorderLayout.CENTER);
        add(finishPanel, BorderLayout.SOUTH);

        // Pack and set visible
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void SetActionListener(ActionListener listener){
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

    public void setUserCash(double userCash) {
        // Sets the text at the bottom of Enter Money to whatever the userCash is.
        cashTrackerLabel = new JLabel();
        cashTrackerLabel.setText("Current Cash: ₱" + userCash);
    }
}