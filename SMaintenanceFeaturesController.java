import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SMaintenanceFeaturesController implements ActionListener {

    private final SpecialMaintenanceFeatures gui;
    private final SpecialVendingMachine specialVendingMachine;

    public SMaintenanceFeaturesController(SpecialMaintenanceFeatures gui, SpecialVendingMachine specialVendingMachine){
        this.specialVendingMachine = specialVendingMachine;
        this.gui = gui;
        gui.setActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Item")) {
            System.out.println("You chose Add Item!");
        } else if (e.getActionCommand().equals("Change Price")) {
            System.out.println("You chose Change Price!");
        } else if (e.getActionCommand().equals("Add to Cannot Be Sold Separately")) {
            System.out.println("You chose Add to Cannot Be Sold Separately!");
        } else if (e.getActionCommand().equals("Collect Payment")) {
            producePayment();
            gui.displayCollectPayment(specialVendingMachine.getTotalPayment());
            for (Money m : specialVendingMachine.paymentList) {
                m.setQuantity(0);
            }
            specialVendingMachine.setTotalPayment(0);
        } else if (e.getActionCommand().equals("Replenish Stock")) {
            System.out.println("You chose Replenish Stock!");
        } else if (e.getActionCommand().equals("Replenish Change")) {
            ReplenishChangeGUI replenishChangeGUI = new ReplenishChangeGUI();
            replenishChangeGUI.init();
            ReplenishChangeGUIControllerSpecial replenishChangeGUIControllerSpecial = new ReplenishChangeGUIControllerSpecial(replenishChangeGUI, specialVendingMachine);
        } else if (e.getActionCommand().equals("Print Purchase Summary")) {
            System.out.println("You chose Replenish Stock!");
        } else if (e.getActionCommand().equals("Back to Test Menu")) {
            gui.Exit();
        }
    }

    public void producePayment() {
        double payment = 0;
        for (Money m : specialVendingMachine.paymentList) {
            payment += m.getValue() * m.getQuantity();
        }
        specialVendingMachine.setTotalPayment(payment);
        if (payment > 0) {
            do {
                if (payment >= 1000) {
                    payment -= 1000;
                    gui.outputList.add("Dispensing ₱1000" + "\n");
                } else if (payment >= 500) {
                    payment -= 500;
                    gui.outputList.add("Dispensing ₱500" + "\n");
                } else if (payment >= 200) {
                    payment -= 200;
                    gui.outputList.add("Dispensing ₱200" + "\n");
                } else if (payment >= 100) {
                    payment -= 100;
                    gui.outputList.add("Dispensing ₱100" + "\n");
                } else if (payment >= 50) {
                    payment -= 50;
                    gui.outputList.add("Dispensing ₱50" + "\n");
                } else if (payment >= 20) {
                    payment -= 20;
                    gui.outputList.add("Dispensing ₱20" + "\n");
                } else if (payment >= 10) {
                    payment -= 10;
                    gui.outputList.add("Dispensing ₱10" + "\n");
                } else if (payment >= 5) {
                    payment -= 5;
                    gui.outputList.add("Dispensing ₱5" + "\n");
                } else if (payment >= 1) {
                    payment -= 1;
                    gui.outputList.add("Dispensing ₱1" + "\n");
                }
            } while (payment != 0);
            gui.outputList.add("Payment collection is complete");
        } else {
            gui.outputList.add("There is no payment to collect");
        }
    }

}
