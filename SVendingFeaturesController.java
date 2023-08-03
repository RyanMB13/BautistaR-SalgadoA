import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SVendingFeaturesController implements ActionListener {

    private final SpecialVendingFeatures gui;
    private final SpecialVendingMachine specialVendingMachine;

    public SVendingFeaturesController(SpecialVendingFeatures gui, SpecialVendingMachine specialVendingMachine) {
        this.gui = gui;
        this.specialVendingMachine = specialVendingMachine;
        gui.setActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter Money")){
            EnterMoneyGUI enterMoneyGUI = new EnterMoneyGUI();
            enterMoneyGUI.init();
            EnterMoneyGUIControllerSpecial enterMoneyGUIControllerSpecial = new EnterMoneyGUIControllerSpecial(enterMoneyGUI, specialVendingMachine);
        } else if (e.getActionCommand().equals("Display Items")){
            System.out.println("You chose Display!");
        }  else if (e.getActionCommand().equals("Purchase Individual Item")){
            System.out.println("You chose Purchase Individual Item!");
        } else if (e.getActionCommand().equals("Purchase Ramen")){
            System.out.println("You chose Purchase Ramen!");
        } else if (e.getActionCommand().equals("Produce Change")){
            produceChange();
            gui.displayProduceChange(specialVendingMachine.getUserCash());
            for (Money m : specialVendingMachine.userCashList){
                m.setQuantity(0);
            }
            specialVendingMachine.setUserCash(0); // Reset userCash
        } else if (e.getActionCommand().equals("Back to Test Menu")){
            gui.Exit();
        }

    }
    public void produceChange() {
        double change = specialVendingMachine.getUserCash();
        //Update VMChange
        specialVendingMachine.setVMChange(specialVendingMachine.getVMChange() - change);
        if (change > 0) {
            do {
                if (change >= 1000) {
                    if (specialVendingMachine.VMChangeList.get(0).getQuantity() > 0) {
                        change -= 1000;
                        specialVendingMachine.VMChangeList.get(0).setQuantity(specialVendingMachine.VMChangeList.get(0).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱1000" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 500) {
                    if (specialVendingMachine.VMChangeList.get(1).getQuantity() > 0) {
                        change -= 500;
                        specialVendingMachine.VMChangeList.get(1).setQuantity(specialVendingMachine.VMChangeList.get(1).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱500" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 200) {
                    if (specialVendingMachine.VMChangeList.get(2).getQuantity() > 0) {
                        change -= 200;
                        specialVendingMachine.VMChangeList.get(2).setQuantity(specialVendingMachine.VMChangeList.get(2).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱200" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 100) {
                    if (specialVendingMachine.VMChangeList.get(3).getQuantity() > 0) {
                        change -= 100;
                        specialVendingMachine.VMChangeList.get(3).setQuantity(specialVendingMachine.VMChangeList.get(3).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱100" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 50) {
                    if (specialVendingMachine.VMChangeList.get(4).getQuantity() > 0) {
                        change -= 50;
                        specialVendingMachine.VMChangeList.get(4).setQuantity(specialVendingMachine.VMChangeList.get(4).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱50" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 20) {
                    if (specialVendingMachine.VMChangeList.get(5).getQuantity() > 0) {
                        change -= 20;
                        specialVendingMachine.VMChangeList.get(5).setQuantity(specialVendingMachine.VMChangeList.get(5).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱20" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 10) {
                    if (specialVendingMachine.VMChangeList.get(6).getQuantity() > 0) {
                        change -= 10;
                        specialVendingMachine.VMChangeList.get(6).setQuantity(specialVendingMachine.VMChangeList.get(6).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱10" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 5) {
                    if (specialVendingMachine.VMChangeList.get(7).getQuantity() > 0) {
                        change -= 5;
                        specialVendingMachine.VMChangeList.get(7).setQuantity(specialVendingMachine.VMChangeList.get(7).getQuantity() - 1);
                        gui.outputList.add("Dispensing ₱5" + "\n");
                    } else {
                        gui.outputList.add("Not enough money to produce change, please ask the owner to replenish change.");
                        break;
                    }
                } else if (change >= 1) {
                    if (specialVendingMachine.VMChangeList.get(8).getQuantity() > 0) {
                        change -= 1;
                        specialVendingMachine.VMChangeList.get(8).setQuantity(specialVendingMachine.VMChangeList.get(8).getQuantity() - 1);
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
