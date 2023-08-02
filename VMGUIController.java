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
            VendingMachineOptions VMOptions = new VendingMachineOptions();
            VMOptionsController VMOptionsController = new VMOptionsController(VMOptions);
            VMOptions.init();
            setVMCreated(true);
        } else if (e.getActionCommand().equals("Test Features")) {
            if (getVMCreated()){
                System.out.println("TEST FEATURES SUCCESS"); // incomplete code.
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
