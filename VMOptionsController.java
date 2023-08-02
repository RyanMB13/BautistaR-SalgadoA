import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMOptionsController implements ActionListener {
    private final VendingMachineOptions gui; // View
    private boolean isRegularVendingMachine;

    public VMOptionsController(VendingMachineOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Regular Vending Machine")) {
            gui.RegularSelectedDisplay();
            setIsRegularVendingMachine(true);
        } else if (e.getActionCommand().equals("Special Vending Machine")){
            gui.SpecialSelectedDisplay();
            setIsRegularVendingMachine(false);
        }
    }

    public void setIsRegularVendingMachine(boolean regular){
        this.isRegularVendingMachine = regular;
    }

    public boolean getIsRegularVendingMachine(){ return this.isRegularVendingMachine; }

}
