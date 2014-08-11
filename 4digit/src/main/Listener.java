package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Frantsuzov S.
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
