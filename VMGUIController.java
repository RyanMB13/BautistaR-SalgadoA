import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMGUIController implements ActionListener {
    private final VendingMachineGUI gui; // View
    private boolean VMCreated = false;
    private boolean isRegularVM;
    public VMGUIController(VendingMachineGUI gui){
        this.gui = gui;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Vending Machine")) {
            VendingMachineOptions VMOptions = new VendingMachineOptions();
            VMOptions.init();
            VMOptionsController VMOptionsController = new VMOptionsController(VMOptions);
            setVMCreated(true);
            setIsRegularVM(VMOptionsController.getIsRegularVM());
        } else if (e.getActionCommand().equals("Test Features")) {
            if (getVMCreated()){
                VendingMachineTestFeaturesOptions VMTFOptions = new VendingMachineTestFeaturesOptions();
                VMTFOptions.init();
                VMTFOptionsController VMTFOController = new VMTFOptionsController(VMTFOptions);
                VMTFOController.setIsRegularVM(getIsRegularVM());
            } else {
                JOptionPane.showMessageDialog(gui, "Vending Machine has not yet been created.","Vending Machine", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
    public void setVMCreated(boolean created){
        this.VMCreated = created;
    }
    public boolean getVMCreated(){ return this.VMCreated; }

    public void setIsRegularVM(boolean regular) {
        this.isRegularVM = regular;
    }

    public boolean getIsRegularVM() { return this.isRegularVM; }

}
