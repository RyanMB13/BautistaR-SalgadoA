import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RVendingFeaturesController implements ActionListener {

    private final RegularVendingFeatures gui; // View
    private final VendingMachine vendingMachine; // Model
    private final SpecialVendingMachine specialVendingMachine; //Model

    public RVendingFeaturesController(RegularVendingFeatures gui, VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine) {
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter Money")) {
            EnterMoneyGUI enterMoneyGUI = new EnterMoneyGUI();

            enterMoneyGUI.init();

            EnterMoneyGUIController enterMoneyGUIController = new EnterMoneyGUIController(enterMoneyGUI, vendingMachine, specialVendingMachine);
        } else if (e.getActionCommand().equals("Display Items")) {
            ItemDisplayGUI displayItemGUI = new ItemDisplayGUI(vendingMachine.itemList, vendingMachine, specialVendingMachine);

            displayItemGUI.init();
        } else if (e.getActionCommand().equals("Purchase Item")) {
            System.out.print("You selected Purchase Item");
        } else if (e.getActionCommand().equals("Produce Change")) {
            produceChange();
            gui.displayProduceChange(vendingMachine.getUserCash());
            // Reset userCash
            vendingMachine.setUserCash(0);
        } else if (e.getActionCommand().equals("Back to Test Menu")) {
            gui.Exit();
        }
    }

    public void produceChange() {
        double change = vendingMachine.getUserCash();
        //Update VMChange
        vendingMachine.setVMChange(vendingMachine.getVMChange() - change);
        if (change > 0) {
            do {
                if (change >= 1000) {
                    if (vendingMachine.VMChangeList.get(0).getQuantity() > 0) {
                        change -= 1000;
                        vendingMachine.VMChangeList.get(0).setQuantity(vendingMachine.VMChangeList.get(0).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱1000" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 500) {
                    if (vendingMachine.VMChangeList.get(1).getQuantity() > 0) {
                        change -= 500;
                        vendingMachine.VMChangeList.get(1).setQuantity(vendingMachine.VMChangeList.get(1).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱500" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 200) {
                    if (vendingMachine.VMChangeList.get(2).getQuantity() > 0) {
                        change -= 200;
                        vendingMachine.VMChangeList.get(2).setQuantity(vendingMachine.VMChangeList.get(2).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱200" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 100) {
                    if (vendingMachine.VMChangeList.get(3).getQuantity() > 0) {
                        change -= 100;
                        vendingMachine.VMChangeList.get(3).setQuantity(vendingMachine.VMChangeList.get(3).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱100" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 50) {
                    if (vendingMachine.VMChangeList.get(4).getQuantity() > 0) {
                        change -= 50;
                        vendingMachine.VMChangeList.get(4).setQuantity(vendingMachine.VMChangeList.get(4).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱50" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 20) {
                    if (vendingMachine.VMChangeList.get(5).getQuantity() > 0) {
                        change -= 20;
                        vendingMachine.VMChangeList.get(5).setQuantity(vendingMachine.VMChangeList.get(5).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱20" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 10) {
                    if (vendingMachine.VMChangeList.get(6).getQuantity() > 0) {
                        change -= 10;
                        vendingMachine.VMChangeList.get(6).setQuantity(vendingMachine.VMChangeList.get(6).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱10" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 5) {
                    if (vendingMachine.VMChangeList.get(7).getQuantity() > 0) {
                        change -= 5;
                        vendingMachine.VMChangeList.get(7).setQuantity(vendingMachine.VMChangeList.get(7).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱5" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 1) {
                    if (vendingMachine.VMChangeList.get(8).getQuantity() > 0) {
                        change -= 1;
                        vendingMachine.VMChangeList.get(8).setQuantity(vendingMachine.VMChangeList.get(8).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱1" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                }
            } while (change != 0);
            gui.outputList.add("Change produced successfully!");
        } else {
            gui.outputList.add("You do not have change.");
        }
    }
}
