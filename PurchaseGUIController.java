import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseGUIController implements ActionListener {

    private final PurchaseGUI gui; // View
    private final VendingMachine vendingMachine; // Model

    public PurchaseGUIController(PurchaseGUI gui, VendingMachine vendingMachine) {
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Purchase")) {
            int index = 0;
            String name = gui.getItemName();

            for (int i = 0; i < vendingMachine.itemList.size(); i++){
                if (name.equalsIgnoreCase(vendingMachine.itemList.get(i).getName())) {
                    index = i;
                    break;
                }
            }

            Item item = vendingMachine.itemList.get(index);

            if (vendingMachine.VMChangeList.get(0).getQuantity() == 0 || vendingMachine.VMChangeList.get(1).getQuantity() == 0 ||
                    vendingMachine.VMChangeList.get(2).getQuantity() == 0 || vendingMachine.VMChangeList.get(3).getQuantity() == 0 ||
                    vendingMachine.VMChangeList.get(4).getQuantity() == 0 || vendingMachine.VMChangeList.get(5).getQuantity() == 0 ||
                    vendingMachine.VMChangeList.get(6).getQuantity() == 0 || vendingMachine.VMChangeList.get(7).getQuantity() == 0 ||
                    vendingMachine.VMChangeList.get(8).getQuantity() == 0) {
                gui.showNotEnoughChangeMessage();
            } else {
                if (item.getStock() >= 1) {
                    if (item.getPrice() <= vendingMachine.getUserCash()) {
                        vendingMachine.setUserCash(vendingMachine.getUserCash() - item.getPrice());
                        item.setStock(item.getStock() - 1);
                        vendingMachine.setSold(vendingMachine.getSold() + 1);
                        vendingMachine.setTotalSales(vendingMachine.getTotalSales() + item.getPrice());
                        gui.showPurchaseConfirmation(item.getName());
                    } else {
                        gui.showNotEnoughCashMessage();
                    }
                } else {
                    gui.showNotEnoughStockMessage();
                }
            }
        } else if (e.getActionCommand().equals("Go Back")) {
            gui.Exit();
            System.out.println("BACK");
        }
    }
}
