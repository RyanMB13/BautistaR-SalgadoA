import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplenishChangeGUIControllerSpecial implements ActionListener {

    private final SpecialVendingMachine specialVendingMachine;

    private final ReplenishChangeGUI gui;

    public ReplenishChangeGUIControllerSpecial(ReplenishChangeGUI gui, SpecialVendingMachine specialVendingMachine) {
        this.gui = gui;
        this.specialVendingMachine = specialVendingMachine;
        gui.setActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("₱1000")) {
            specialVendingMachine.VMChangeList.get(0).setQuantity(specialVendingMachine.VMChangeList.get(0).getQuantity() + 1);
            gui.setDisplayCash(1000);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱500")) {
            specialVendingMachine.VMChangeList.get(1).setQuantity(specialVendingMachine.VMChangeList.get(1).getQuantity() + 1);
            gui.setDisplayCash(500);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱200")) {
            specialVendingMachine.VMChangeList.get(2).setQuantity(specialVendingMachine.VMChangeList.get(2).getQuantity() + 1);
            gui.setDisplayCash(200);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱100")) {
            specialVendingMachine.VMChangeList.get(3).setQuantity(specialVendingMachine.VMChangeList.get(3).getQuantity() + 1);
            gui.setDisplayCash(100);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱50")) {
            specialVendingMachine.VMChangeList.get(4).setQuantity(specialVendingMachine.VMChangeList.get(4).getQuantity() + 1);
            gui.setDisplayCash(50);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱20")) {
            specialVendingMachine.VMChangeList.get(5).setQuantity(specialVendingMachine.VMChangeList.get(5).getQuantity() + 1);
            gui.setDisplayCash(20);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱10")) {
            specialVendingMachine.VMChangeList.get(6).setQuantity(specialVendingMachine.VMChangeList.get(6).getQuantity() + 1);
            gui.setDisplayCash(10);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱5")) {
            specialVendingMachine.VMChangeList.get(7).setQuantity(specialVendingMachine.VMChangeList.get(7).getQuantity() + 1);
            gui.setDisplayCash(5);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱1")) {
            specialVendingMachine.VMChangeList.get(8).setQuantity(specialVendingMachine.VMChangeList.get(8).getQuantity() + 1);
            gui.setDisplayCash(1);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("Finish Adding Money")) {
            double prevCash = specialVendingMachine.getVMChange();
            double totalCash = 0;
            for (Money m : specialVendingMachine.VMChangeList) {
                totalCash += m.getValue() * m.getQuantity();
            }
            specialVendingMachine.setVMChange(totalCash);
            gui.displayEnteredCashMessage(prevCash, specialVendingMachine.getVMChange());
            gui.setDisplayCash(0);
            gui.Exit();
        }
    }
}
