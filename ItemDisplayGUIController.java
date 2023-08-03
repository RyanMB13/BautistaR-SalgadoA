import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemDisplayGUIController implements ActionListener {

    private final ItemDisplayGUI gui;

    public ItemDisplayGUIController(ItemDisplayGUI gui) {
        this.gui = gui;
        gui.setActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to Vending Features")) {
            gui.goBack();
        }
    }
}
