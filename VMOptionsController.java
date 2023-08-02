import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMOptionsController implements ActionListener {
    private final VendingMachineOptions gui;
    public VMOptionsController(VendingMachineOptions gui) {
        this.gui = gui;
        gui.SetActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
