import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterMoneyGUIController implements ActionListener {
    private final EnterMoneyGUI gui;
    private final VendingMachine regularVendingMachine;

    public EnterMoneyGUIController(EnterMoneyGUI gui, VendingMachine vendingMachine) {
        this.gui = gui;
        this.regularVendingMachine = vendingMachine;
        gui.SetActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("₱1000")) {
            regularVendingMachine.userCashList.get(0).setQuantity(regularVendingMachine.userCashList.get(0).getQuantity() + 1);
            regularVendingMachine.paymentList.get(0).setQuantity(regularVendingMachine.paymentList.get(0).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("ISANG LIBO");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱500")) {
            regularVendingMachine.userCashList.get(1).setQuantity(regularVendingMachine.userCashList.get(1).getQuantity() + 1);
            regularVendingMachine.paymentList.get(1).setQuantity(regularVendingMachine.paymentList.get(1).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("LIMANG DAAN");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱200")) {
            regularVendingMachine.userCashList.get(2).setQuantity(regularVendingMachine.userCashList.get(2).getQuantity() + 1);
            regularVendingMachine.paymentList.get(2).setQuantity(regularVendingMachine.paymentList.get(2).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("DALAWANG DAAN");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱100")) {
            regularVendingMachine.userCashList.get(3).setQuantity(regularVendingMachine.userCashList.get(3).getQuantity() + 1);
            regularVendingMachine.paymentList.get(3).setQuantity(regularVendingMachine.paymentList.get(3).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("ISANG DAAN");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱50")) {
            regularVendingMachine.userCashList.get(4).setQuantity(regularVendingMachine.userCashList.get(4).getQuantity() + 1);
            regularVendingMachine.paymentList.get(4).setQuantity(regularVendingMachine.paymentList.get(4).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("PIPTI");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱20")) {
            regularVendingMachine.userCashList.get(5).setQuantity(regularVendingMachine.userCashList.get(5).getQuantity() + 1);
            regularVendingMachine.paymentList.get(5).setQuantity(regularVendingMachine.paymentList.get(5).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("BENTE");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱10")) {
            regularVendingMachine.userCashList.get(6).setQuantity(regularVendingMachine.userCashList.get(6).getQuantity() + 1);
            regularVendingMachine.paymentList.get(6).setQuantity(regularVendingMachine.paymentList.get(6).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("SAMPU");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱5")) {
            regularVendingMachine.userCashList.get(7).setQuantity(regularVendingMachine.userCashList.get(7).getQuantity() + 1);
            regularVendingMachine.paymentList.get(7).setQuantity(regularVendingMachine.paymentList.get(7).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("LIMA");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("₱1")) {
            regularVendingMachine.userCashList.get(8).setQuantity(regularVendingMachine.userCashList.get(8).getQuantity() + 1);
            regularVendingMachine.paymentList.get(8).setQuantity(regularVendingMachine.paymentList.get(8).getQuantity() + 1);
            gui.setUserCash(regularVendingMachine.getUserCash());
            System.out.println("I MISS YOU");
            System.out.println(regularVendingMachine.getUserCash());
        } else if (e.getActionCommand().equals("Finish Adding Money")) {
            double totalCash = 0;
            for (Money m : regularVendingMachine.userCashList){
                totalCash += m.getValue() * m.getQuantity();
            }
            regularVendingMachine.setUserCash(regularVendingMachine.getUserCash() + totalCash);
            gui.Exit();
        }
    }
}

