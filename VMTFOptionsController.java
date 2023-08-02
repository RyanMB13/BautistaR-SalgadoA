import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMTFOptionsController implements ActionListener {

    private final VendingMachineTestFeaturesOptions gui;

    public VMTFOptionsController(VendingMachineTestFeaturesOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vending Machine Features")) {
            RegularVendingFeatures features = new RegularVendingFeatures();

            features.init();
        } else if (e.getActionCommand().equals("Maintenance Features")) {

        } else if (e.getActionCommand().equals("Exit")){

        }
    }
}
