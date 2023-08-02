import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RVendingFeaturesController implements ActionListener {

    private final RegularVendingFeatures gui;

    public RVendingFeaturesController(RegularVendingFeatures gui){
        this.gui = gui;
        gui.setActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
