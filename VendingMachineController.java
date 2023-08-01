import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController implements ActionListener, DocumentListener {
    private final VendingMachineGUI gui1; // View
    private final VendingMachine regularVM; // Model
    private final SpecialVendingMachine specialVM; // Model

    public VendingMachineController(VendingMachineGUI gui1, VendingMachine regularVM, SpecialVendingMachine specialVM){

        this.gui1 = gui1;
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


    }

    public void updateEnterMoneyView(){
        // Regular Vending Machine
       // gui3.setUserCash(regularVM.getUserCash()); // Updates current cash display in enter money menu
        // Special Vending Machine
       // gui5.setUserCash(specialVM.getUserCash()); // Updates current cash display in enter money menu
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1000")) {
            regularVM.userCashList.get(0).setQuantity(regularVM.userCashList.get(0).getQuantity() + 1);
            regularVM.paymentList.get(0).setQuantity(regularVM.paymentList.get(0).getQuantity() + 1);
            specialVM.userCashList.get(0).setQuantity(specialVM.userCashList.get(0).getQuantity() + 1);
            specialVM.paymentList.get(0).setQuantity(specialVM.paymentList.get(0).getQuantity() + 1);
            System.out.println("ISANG LIBO");
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("500")) {
            regularVM.userCashList.get(1).setQuantity(regularVM.userCashList.get(1).getQuantity() + 1);
            regularVM.paymentList.get(1).setQuantity(regularVM.paymentList.get(1).getQuantity() + 1);
            specialVM.userCashList.get(1).setQuantity(specialVM.userCashList.get(1).getQuantity() + 1);
            specialVM.paymentList.get(1).setQuantity(specialVM.paymentList.get(1).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("200")) {
            regularVM.userCashList.get(2).setQuantity(regularVM.userCashList.get(2).getQuantity() + 1);
            regularVM.paymentList.get(2).setQuantity(regularVM.paymentList.get(2).getQuantity() + 1);
            specialVM.userCashList.get(2).setQuantity(specialVM.userCashList.get(2).getQuantity() + 1);
            specialVM.paymentList.get(2).setQuantity(specialVM.paymentList.get(2).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("100")) {
            regularVM.userCashList.get(3).setQuantity(regularVM.userCashList.get(3).getQuantity() + 1);
            regularVM.paymentList.get(3).setQuantity(regularVM.paymentList.get(3).getQuantity() + 1);
            specialVM.userCashList.get(3).setQuantity(specialVM.userCashList.get(3).getQuantity() + 1);
            specialVM.paymentList.get(3).setQuantity(specialVM.paymentList.get(3).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("50")) {
            regularVM.userCashList.get(4).setQuantity(regularVM.userCashList.get(4).getQuantity() + 1);
            regularVM.paymentList.get(4).setQuantity(regularVM.paymentList.get(4).getQuantity() + 1);
            specialVM.userCashList.get(4).setQuantity(specialVM.userCashList.get(4).getQuantity() + 1);
            specialVM.paymentList.get(4).setQuantity(specialVM.paymentList.get(4).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("20")) {
            regularVM.userCashList.get(5).setQuantity(regularVM.userCashList.get(5).getQuantity() + 1);
            regularVM.paymentList.get(5).setQuantity(regularVM.paymentList.get(5).getQuantity() + 1);
            specialVM.userCashList.get(5).setQuantity(specialVM.userCashList.get(5).getQuantity() + 1);
            specialVM.paymentList.get(5).setQuantity(specialVM.paymentList.get(5).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("10")) {
            regularVM.userCashList.get(6).setQuantity(regularVM.userCashList.get(6).getQuantity() + 1);
            regularVM.paymentList.get(6).setQuantity(regularVM.paymentList.get(6).getQuantity() + 1);
            specialVM.userCashList.get(6).setQuantity(specialVM.userCashList.get(6).getQuantity() + 1);
            specialVM.paymentList.get(6).setQuantity(specialVM.paymentList.get(6).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("5")) {
            regularVM.userCashList.get(7).setQuantity(regularVM.userCashList.get(7).getQuantity() + 1);
            regularVM.paymentList.get(7).setQuantity(regularVM.paymentList.get(7).getQuantity() + 1);
            specialVM.userCashList.get(7).setQuantity(specialVM.userCashList.get(7).getQuantity() + 1);
            specialVM.paymentList.get(7).setQuantity(specialVM.paymentList.get(7).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("1")) {
            regularVM.userCashList.get(8).setQuantity(regularVM.userCashList.get(8).getQuantity() + 1);
            regularVM.paymentList.get(8).setQuantity(regularVM.paymentList.get(8).getQuantity() + 1);
            specialVM.userCashList.get(8).setQuantity(specialVM.userCashList.get(8).getQuantity() + 1);
            specialVM.paymentList.get(8).setQuantity(specialVM.paymentList.get(8).getQuantity() + 1);
            updateEnterMoneyView();
        } else if (e.getActionCommand().equals("Finish Adding Money")){
            double totalCash = 0;
            for (Money money : regularVM.userCashList) {
                totalCash += money.getValue() * money.getQuantity();
            }
            for (Money money : specialVM.userCashList) {
                totalCash += money.getValue() * money.getQuantity();
            }
            regularVM.setUserCash(totalCash);
            specialVM.setUserCash(totalCash);
            updateEnterMoneyView();
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
