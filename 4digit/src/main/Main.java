package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Frantsuzov S.
 */
public class Main extends JFrame {

    JLabel lbl;
    JLabel message;
    JFormattedTextField input;
    JButton btn;
    JTextArea list;

    /**
     *
     * @param args
     * @throws ParseException
     */
    public Main(String[] args) throws ParseException {
        super("Game Bulls and Cows");
        setLocation(200, 200);
        setPreferredSize(new Dimension(250, 350));
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Listener listener = new Listener(this);
        addWindowListener(listener);
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        lbl = new JLabel("Input:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(lbl, c);

        input = new JFormattedTextField(formatter("####"));
        input.setPreferredSize(new Dimension(50, 25));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        add(input, c);

        btn = new JButton("Enter");
        btn.addActionListener(listener);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        add(btn, c);

        list = new JTextArea();
        list.setBackground(SystemColor.control);
        list.setEditable(false);
        list.setLineWrap(rootPaneCheckingEnabled);
        list.setWrapStyleWord(rootPaneCheckingEnabled);
        JScrollPane scroll = new JScrollPane(list);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 10;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.insets = new Insets(5, 5, 5, 5);
        add(scroll, c);

        message = new JLabel("Hello! Let`s play!");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 5, 5, 5);
        add(message, c);

        pack();
        setVisible(true);
    }

    /**
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        new Main(args);
    }

    public void setAnswer() {
        this.list.append(input.getText() + "\n");
    }
    
    private MaskFormatter formatter(String mask) throws ParseException{
        MaskFormatter mf = new MaskFormatter(mask);
        mf.setValidCharacters("1234567890");
        return mf;
    }
}
