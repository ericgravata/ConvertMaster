package convertmaster;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;

public class ConvertMaster {

    public static void main(String[] args) {
        //Colar telas aqui
        //teste 1: guilhermetell
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            //COLA AS TELAS AQUI
            new TelaDeSplash().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
