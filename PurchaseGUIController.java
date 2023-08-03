import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseGUIController implements ActionListener {

    private final PurchaseGUI gui; // View
    private final VendingMachine vendingMachine; // Model

    public PurchaseGUIController(PurchaseGUI gui, VendingMachine vendingMachine) {
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
