import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseSummaryGUIController implements ActionListener {

    private final PurchaseSummaryGUI gui;
    public PurchaseSummaryGUIController(PurchaseSummaryGUI purchaseSummaryGUI){
        this.gui = purchaseSummaryGUI;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Go Back")){
            gui.Exit();
        }
    }
}
