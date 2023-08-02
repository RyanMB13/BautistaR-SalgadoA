import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMGUIController implements ActionListener {
    private final VendingMachineGUI gui; // View
    private boolean VMCreated = false;
    public VMGUIController(VendingMachineGUI gui){
        this.gui = gui;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Vending Machine")) {
            setVMCreated(true);
            VendingMachineOptions VMOptions = new VendingMachineOptions();
            VMOptions.init();
            VMOptionsController VMOptionsController = new VMOptionsController(VMOptions);
        } else if (e.getActionCommand().equals("Test Features")) {
            if (getVMCreated()){
                VendingMachineTestFeaturesOptions VMTFOptions = new VendingMachineTestFeaturesOptions(getVMCreated());
                VMTFOptions.init();
                VMTFOptionsController VMTFOptionsController = new VMTFOptionsController(VMTFOptions);
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
}
