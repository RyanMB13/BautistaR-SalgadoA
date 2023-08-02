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
            gui.hideParentFrame();
            if (gui.getIsRegularVM()) {
                RegularVendingFeatures RVendingFeatures = new RegularVendingFeatures();
                // controller
                RVendingFeatures.init();
            } else if (!gui.getIsRegularVM()){
                SpecialVendingFeatures SVendingFeatures = new SpecialVendingFeatures();
                // controller
                SVendingFeatures.init();
            }
        } else if (e.getActionCommand().equals("Maintenance Features")) {
            gui.hideParentFrame();
            if (gui.getIsRegularVM()) {
                RegularMaintenanceFeatures RMaintenanceFeatures = new RegularMaintenanceFeatures();
                // controller
                RMaintenanceFeatures.init();
            } else if (!gui.getIsRegularVM()){
                SpecialMaintenanceFeatures SMaintenanceFeatures = new SpecialMaintenanceFeatures();
                // controller
                SMaintenanceFeatures.init();
            }
        } else if (e.getActionCommand().equals("Exit")){
            gui.exitButton();
        }
    }
}
