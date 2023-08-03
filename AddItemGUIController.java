import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemGUIController implements ActionListener, DocumentListener {

    private final AddItemGUI gui;

    private final VendingMachine vendingMachine;

    public AddItemGUIController(AddItemGUI addItemGUI, VendingMachine vendingMachine) {
        this.gui = addItemGUI;
        this.vendingMachine = vendingMachine;
        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Item")) {
            boolean validName = true;
            boolean validCalories = true;
            boolean validPrice = true;
            boolean validStock = true;

            String name = gui.getItemName();
            for (Item i : vendingMachine.itemList){
                if (name.equalsIgnoreCase(i.getName())) {
                    gui.errorList.add("Inputted Name has duplicate in Vending Machine" + "\n");
                    validName = false;
                    break;
                }
            }

            String sCalories = gui.getItemCalories();
            int calories = 0;
            try {
                calories = Integer.parseInt(sCalories);
                if (calories < 0) {
                    gui.errorList.add("Inputted Calories cannot be less than 0" + "\n");
                    validCalories = false;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: Unable to parse the calories as an Integer.");
            }

            String sPrice = gui.getItemPrice();
            double price = 0;
            try {
                price = Double.parseDouble(sPrice);
                if (price < 0) {
                    gui.errorList.add("Inputted Price cannot be less than 0" + "\n");
                    validPrice = false;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: Unable to parse the price as an Integer.");
            }

            String sStock = gui.getItemStock();
            int stock = 0;
            try {
                stock = Integer.parseInt(sStock);
                if (stock < 10) {
                    gui.errorList.add("Inputted Stock cannot be less than 10" + "\n");
                    validStock = false;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: Unable to parse the stock as an Integer.");
            }

            if (validName && validCalories && validPrice && validStock) {
                vendingMachine.itemList.add(new Item(name, calories, price, stock));
                gui.displayAdd(name, calories, price, stock);
            } else {
                gui.displayInvalidInput();
            }
        } else if (e.getActionCommand().equals("Back to Maintenance Features")) {
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
