package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author <strong >S.N. Frantsuzov, 2014</strong>
 * @version 1.0
 */
class Listener extends WindowAdapter implements ActionListener {
    
    private final Main main;
    
    public Listener(Main main) {
        this.main = main;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        main.setAnswer();
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        main.dispose();
    }
    
}
