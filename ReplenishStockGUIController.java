
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplenishStockGUIController implements ActionListener {

    private final VendingMachine vendingMachine;

    private final ReplenishStockGUI gui;

    public ReplenishStockGUIController(VendingMachine vendingMachine, ReplenishStockGUI gui){
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        gui.setActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Replenish Stock")) {
            Item item = vendingMachine.itemList.get(gui.getSelectedIndex() - 1);
            gui.outputList.add("Previous Stock: " + item.getStock() + "\n");
            item.setStock(item.getStock() + gui.getStockValue());
            gui.outputList.add("Current Stock: " + item.getStock() + "\n");
            gui.showRestockMessage(item.getName());
            gui.Exit();
        } else if (e.getActionCommand().equals("Go Back")){
            gui.Exit();
        }

    }
}
