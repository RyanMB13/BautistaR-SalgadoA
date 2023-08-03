import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePriceGUIController implements ActionListener, DocumentListener {

    private final VendingMachine vendingMachine;

    private final ChangePriceGUI gui;

    public ChangePriceGUIController(VendingMachine vendingMachine, ChangePriceGUI gui){
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Change Price")){
            Item item = vendingMachine.itemList.get(gui.getSelectedIndex() - 1);
            gui.outputList.add("Previous Price: " + item.getPrice() + "\n");

            String sPrice = gui.getNewPrice();
            double price = 0;
            try {
                price = Double.parseDouble(sPrice);
                if (price < 0) {
                    gui.outputList.add("Inputted Price cannot be less than 0" + "\n");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: Unable to parse the price as an Integer.");
            }
            item.setPrice(price);
            gui.outputList.add("Current Price: " + item.getPrice() + "\n");
            gui.showChangePriceMessage(item.getName());
            gui.Exit();
        } else if (e.getActionCommand().equals("Go Back")){
            gui.Exit();
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
