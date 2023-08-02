import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMOptionsController implements ActionListener {
    private final VendingMachineOptions gui; // View
    private boolean isRegularVendingMachine = true;
    public VMOptionsController(VendingMachineOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Regular Vending Machine")) {
            setIsRegularVM(true);
            gui.RegularSelectedDisplay();
            VendingMachineTestFeaturesOptions VMTestFeatures = new VendingMachineTestFeaturesOptions();
            VMTFOptionsController VMTestFeaturesController = new VMTFOptionsController(VMTestFeatures);
            VMTestFeatures.init();
        } else if (e.getActionCommand().equals("Special Vending Machine")){
            setIsRegularVM(false);
            gui.SpecialSelectedDisplay();
            VendingMachineTestFeaturesOptions VMTestFeatures = new VendingMachineTestFeaturesOptions();
            VMTFOptionsController VMTestFeaturesController = new VMTFOptionsController(VMTestFeatures);
            VMTestFeatures.init();
        }
    }

    public void setIsRegularVM(boolean regular){
        this.isRegularVendingMachine = regular;
    }

    public boolean getIsRegularVM(){ return this.isRegularVendingMachine; }

}
