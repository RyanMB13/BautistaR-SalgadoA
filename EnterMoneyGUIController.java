import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterMoneyGUIController implements ActionListener {
    private final EnterMoneyGUI gui;

    private final VendingMachine regularVendingMachine;

    private final SpecialVendingMachine specialVendingMachine;


    public EnterMoneyGUIController(EnterMoneyGUI gui, VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine) {
        this.gui = gui;
        gui.SetActionListener(this);
        this.regularVendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1000")) {


        } else if (e.getActionCommand().equals("500")) {

        } else if (e.getActionCommand().equals("200")) {

        } else if (e.getActionCommand().equals("100")) {

        } else if (e.getActionCommand().equals("50")) {

        } else if (e.getActionCommand().equals("20")) {

        } else if (e.getActionCommand().equals("10")) {

        } else if (e.getActionCommand().equals("5")) {

        } else if (e.getActionCommand().equals("1")) {

        }
    }
}

