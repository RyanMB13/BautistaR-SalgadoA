import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMTFOptionsController implements ActionListener {

    private final VendingMachineTestFeaturesOptions gui;
    private final VendingMachine regularVendingMachine;
    private final SpecialVendingMachine specialVendingMachine;
    private boolean isRegularVM;

    public VMTFOptionsController(VendingMachineTestFeaturesOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
        this.regularVendingMachine = new VendingMachine();
        this.specialVendingMachine = new SpecialVendingMachine();

        // Initializing arrayLists
        this.regularVendingMachine.addItems();
        this.specialVendingMachine.addItems();
        this.regularVendingMachine.addMoney();
        this.specialVendingMachine.addMoney();

        specialVendingMachine.updateUniqueItemList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vending Machine Features")) {
            gui.hideParentFrame();
            if (getIsRegularVM()) {
                RegularVendingFeatures RVendingFeatures = new RegularVendingFeatures();
                RVendingFeatures.init();
                RVendingFeaturesController RVendingFeaturesController = new RVendingFeaturesController(RVendingFeatures, regularVendingMachine);
            } else if (!getIsRegularVM()){
                SpecialVendingFeatures SVendingFeatures = new SpecialVendingFeatures();
                SVendingFeatures.init();
                SVendingFeaturesController sVendingFeaturesController = new SVendingFeaturesController(SVendingFeatures, specialVendingMachine);
            }
        } else if (e.getActionCommand().equals("Maintenance Features")) {
            gui.hideParentFrame();
            if (getIsRegularVM()) {
                RegularMaintenanceFeatures RMaintenanceFeatures = new RegularMaintenanceFeatures();
                RMaintenanceFeatures.init();
                RMaintenanceFeaturesController RMaintenanceFeaturesController = new RMaintenanceFeaturesController(RMaintenanceFeatures, regularVendingMachine);
            } else if (!getIsRegularVM()){
                SpecialMaintenanceFeatures SMaintenanceFeatures = new SpecialMaintenanceFeatures();
                SMaintenanceFeatures.init();
                SMaintenanceFeaturesController sMaintenanceFeaturesController = new SMaintenanceFeaturesController(SMaintenanceFeatures, specialVendingMachine);
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
