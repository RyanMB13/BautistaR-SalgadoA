import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RVendingFeaturesController implements ActionListener {

    private final RegularVendingFeatures gui; // View

    private final VendingMachine vendingMachine; // Model

    private final SpecialVendingMachine specialVendingMachine; //Model



    public RVendingFeaturesController(RegularVendingFeatures gui, VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine ){
        this.gui = gui;
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        gui.setActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter Money")) {
            System.out.print("You selected Enter Money");
        } else if (e.getActionCommand().equals("Display Items")) {
            System.out.print("You selected Display Items");
        } else if (e.getActionCommand().equals("Purchase Item")) {
            System.out.print("You selected Purchase Item");
        } else if (e.getActionCommand().equals("Produce Change")) {
            gui.displayProduceChange();
        } else if (e.getActionCommand().equals("Back to Test Menu")) {
            gui.Exit();
        }
    }
}
