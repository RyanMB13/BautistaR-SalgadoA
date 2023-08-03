import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterMoneyGUIControllerSpecial implements ActionListener {
    private final EnterMoneyGUI gui;
    private final SpecialVendingMachine specialVendingMachine;

    public EnterMoneyGUIControllerSpecial(EnterMoneyGUI gui, SpecialVendingMachine specialVendingMachine) {
        this.gui = gui;
        this.specialVendingMachine = specialVendingMachine;
        gui.SetActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("₱1000")) {
            specialVendingMachine.userCashList.get(0).setQuantity(specialVendingMachine.userCashList.get(0).getQuantity() + 1);
            specialVendingMachine.paymentList.get(0).setQuantity(specialVendingMachine.paymentList.get(0).getQuantity() + 1);
            gui.setDisplayCash(1000);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱500")) {
            specialVendingMachine.userCashList.get(1).setQuantity(specialVendingMachine.userCashList.get(1).getQuantity() + 1);
            specialVendingMachine.paymentList.get(1).setQuantity(specialVendingMachine.paymentList.get(1).getQuantity() + 1);
            gui.setDisplayCash(500);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱200")) {
            specialVendingMachine.userCashList.get(2).setQuantity(specialVendingMachine.userCashList.get(2).getQuantity() + 1);
            specialVendingMachine.paymentList.get(2).setQuantity(specialVendingMachine.paymentList.get(2).getQuantity() + 1);
            gui.setDisplayCash(200);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱100")) {
            specialVendingMachine.userCashList.get(3).setQuantity(specialVendingMachine.userCashList.get(3).getQuantity() + 1);
            specialVendingMachine.paymentList.get(3).setQuantity(specialVendingMachine.paymentList.get(3).getQuantity() + 1);
            gui.setDisplayCash(100);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱50")) {
            specialVendingMachine.userCashList.get(4).setQuantity(specialVendingMachine.userCashList.get(4).getQuantity() + 1);
            specialVendingMachine.paymentList.get(4).setQuantity(specialVendingMachine.paymentList.get(4).getQuantity() + 1);
            gui.setDisplayCash(50);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱20")) {
            specialVendingMachine.userCashList.get(5).setQuantity(specialVendingMachine.userCashList.get(5).getQuantity() + 1);
            specialVendingMachine.paymentList.get(5).setQuantity(specialVendingMachine.paymentList.get(5).getQuantity() + 1);
            gui.setDisplayCash(20);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱10")) {
            specialVendingMachine.userCashList.get(6).setQuantity(specialVendingMachine.userCashList.get(6).getQuantity() + 1);
            specialVendingMachine.paymentList.get(6).setQuantity(specialVendingMachine.paymentList.get(6).getQuantity() + 1);
            gui.setDisplayCash(10);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱5")) {
            specialVendingMachine.userCashList.get(7).setQuantity(specialVendingMachine.userCashList.get(7).getQuantity() + 1);
            specialVendingMachine.paymentList.get(7).setQuantity(specialVendingMachine.paymentList.get(7).getQuantity() + 1);
            gui.setDisplayCash(5);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("₱1")) {
            specialVendingMachine.userCashList.get(8).setQuantity(specialVendingMachine.userCashList.get(8).getQuantity() + 1);
            specialVendingMachine.paymentList.get(8).setQuantity(specialVendingMachine.paymentList.get(8).getQuantity() + 1);
            gui.setDisplayCash(1);
            gui.DisplayCashInput();
        } else if (e.getActionCommand().equals("Finish Adding Money")) {
            double prevCash = specialVendingMachine.getUserCash();
            double totalCash = 0;
            for (Money m : specialVendingMachine.userCashList){
                totalCash += m.getValue() * m.getQuantity();
            }
            specialVendingMachine.setUserCash(totalCash);
            gui.displayEnteredCashMessage(prevCash, specialVendingMachine.getUserCash());
            gui.setDisplayCash(0);
            gui.Exit();
        }
    }
}

