import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController implements ActionListener, DocumentListener {
    private final VendingMachineGUI gui1; // View
    private final VendingMachineOptions gui2; // View
    private final RegularVendingFeatures gui3; // View
    private final RegularMaintenanceFeatures gui4; // View
    private final SpecialVendingFeatures  gui5; // View
    private final SpecialMaintenanceFeatures gui6; // View
    private final VendingMachine regularVM; // Model
    private final SpecialVendingMachine specialVM; // Model

    public VendingMachineController(VendingMachineGUI gui1, VendingMachineOptions gui2, RegularVendingFeatures gui3,
                                    RegularMaintenanceFeatures gui4, SpecialVendingFeatures gui5, SpecialMaintenanceFeatures
                                            gui6, VendingMachine regularVM, SpecialVendingMachine specialVM){

        this.gui1 = gui1;
        this.gui2 = gui2;
        this.gui3 = gui3;
        this.gui4 = gui4;
        this.gui5 = gui5;
        this.gui6 = gui6;
        this.regularVM = regularVM;
        this.specialVM = specialVM;

        updateEnterMoneyView();

        /*
        GUI.setActionListener(this);
        GUI2.setActionListener(this);
        GUI3.setActionListener(this);
        GUI4.setActionListener(this);
        GUI5.setActionListener(this);
        GUI6.setActionListener(this);

        GUI2.setDocumentListener(this);
        GUI3.setDocumentListener(this);
        GUI4.setDocumentListener(this);
        GUI5.setDocumentListener(this);
        GUI6.setDocumentListener(this);
        */

        gui3.setActionListener(this);
        gui5.setActionListener(this);



    }

    public void updateEnterMoneyView(){
        // Regular Vending Machine
        gui3.setUserCash(regularVM.getUserCash()); // Updates current cash display in enter money menu
        // Special Vending Machine
        gui5.setUserCash(specialVM.getUserCash()); // Updates current cash display in enter money menu
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1000")){
            regularVM.setUserCash(regularVM.getUserCash() + 1000);
        }
        else if (e.getActionCommand().equals("500")){
            regularVM.setUserCash(regularVM.getUserCash() + 500);
        }
        else if (e.getActionCommand().equals("200")){
            regularVM.setUserCash(regularVM.getUserCash() + 200);
        }
        else if (e.getActionCommand().equals("100")){
            regularVM.setUserCash(regularVM.getUserCash() + 100);
        }
        else if (e.getActionCommand().equals("50")){
            regularVM.setUserCash(regularVM.getUserCash() + 50);
        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
