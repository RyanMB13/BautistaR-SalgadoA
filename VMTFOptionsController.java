import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMTFOptionsController implements ActionListener {

    private final VendingMachineTestFeaturesOptions gui;

    private boolean isRegularVM;

    public VMTFOptionsController(VendingMachineTestFeaturesOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vending Machine Features")) {
            gui.hideParentFrame();
            if (getIsRegularVM()) {
                RegularVendingFeatures RVendingFeatures = new RegularVendingFeatures();
                RVendingFeatures.init();
                // controller
                System.out.println("R VENDING FEATURES");
            } else if (!getIsRegularVM()){
                SpecialVendingFeatures SVendingFeatures = new SpecialVendingFeatures();
                SVendingFeatures.init();
                // controller
                System.out.println("S VENDING FEATURES");
            }
        } else if (e.getActionCommand().equals("Maintenance Features")) {
            gui.hideParentFrame();
            if (getIsRegularVM()) {
                RegularMaintenanceFeatures RMaintenanceFeatures = new RegularMaintenanceFeatures();
                RMaintenanceFeatures.init();
                // controller
                System.out.println("R MAINTENANCE FEATURES");
            } else if (!getIsRegularVM()){
                SpecialMaintenanceFeatures SMaintenanceFeatures = new SpecialMaintenanceFeatures();
                SMaintenanceFeatures.init();
                // controller
                System.out.println("S MAINTENANCE FEATURES");
            }
        } else if (e.getActionCommand().equals("Exit")){
            gui.exitButton();
        }
    }

    public void setIsRegularVM(boolean regular)
    {
        this.isRegularVM = regular;
    }
    public boolean getIsRegularVM(){ return this.isRegularVM; }

}
