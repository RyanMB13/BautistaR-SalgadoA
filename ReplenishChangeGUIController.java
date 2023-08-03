import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplenishChangeGUIController implements ActionListener {

    private final ReplenishChangeGUI gui;
    private final VendingMachine regularVendingMachine;
    public ReplenishChangeGUIController(ReplenishChangeGUI replenishChangeGUI, VendingMachine regularVendingMachine) {
        this.gui = replenishChangeGUI;
        this.regularVendingMachine = regularVendingMachine;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("₱1000")) {
            regularVendingMachine.VMChangeList.get(0).setQuantity(regularVendingMachine.VMChangeList.get(0).getQuantity() + 1);
            gui.setDisplayCash(1000);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱500")) {
            regularVendingMachine.VMChangeList.get(1).setQuantity(regularVendingMachine.VMChangeList.get(1).getQuantity() + 1);
            gui.setDisplayCash(500);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱200")) {
            regularVendingMachine.VMChangeList.get(2).setQuantity(regularVendingMachine.VMChangeList.get(2).getQuantity() + 1);
            gui.setDisplayCash(200);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱100")) {
            regularVendingMachine.VMChangeList.get(3).setQuantity(regularVendingMachine.VMChangeList.get(3).getQuantity() + 1);
            gui.setDisplayCash(100);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱50")) {
            regularVendingMachine.VMChangeList.get(4).setQuantity(regularVendingMachine.VMChangeList.get(4).getQuantity() + 1);
            gui.setDisplayCash(50);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱20")) {
            regularVendingMachine.VMChangeList.get(5).setQuantity(regularVendingMachine.VMChangeList.get(5).getQuantity() + 1);
            gui.setDisplayCash(20);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱10")) {
            regularVendingMachine.VMChangeList.get(6).setQuantity(regularVendingMachine.VMChangeList.get(6).getQuantity() + 1);
            gui.setDisplayCash(10);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱5")) {
            regularVendingMachine.VMChangeList.get(7).setQuantity(regularVendingMachine.VMChangeList.get(7).getQuantity() + 1);
            gui.setDisplayCash(5);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱1")) {
            regularVendingMachine.VMChangeList.get(8).setQuantity(regularVendingMachine.VMChangeList.get(8).getQuantity() + 1);
            gui.setDisplayCash(1);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("Finish Adding Money")) {
            double prevCash = regularVendingMachine.getVMChange();
            double totalCash = 0;
            for (Money m : regularVendingMachine.VMChangeList){
                totalCash += m.getValue() * m.getQuantity();
            }
            regularVendingMachine.setVMChange(totalCash);
            gui.displayEnteredCashMessage(prevCash, regularVendingMachine.getVMChange());
            gui.setDisplayCash(0);
            gui.Exit();
        }
    }
}
