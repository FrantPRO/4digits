package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Frantsuzov S.
 */
public class Main extends JFrame {

    JLabel lbl;
    JLabel message;
    JTextField input;
    JButton btn;
    JTextArea list;

    public Main(String[] args) {
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

        input = new JTextField();
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

    public static void main(String[] args) {
        new Main(args);
    }

}
