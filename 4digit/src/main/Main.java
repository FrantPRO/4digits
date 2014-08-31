package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.text.ParseException;
import java.util.Random;
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

    private final JLabel lbl;
    private final JLabel message;
    private final JFormattedTextField input;
    private final JButton btn;
    private final JTextArea list;
    private int[] unknownNumber = {1, 2, 3, 4};
    private int[] userNumber = {0, 0, 0, 0};
    private int count;
    private boolean flag = false;

    /**
     *
     * @throws ParseException
     */
    public Main() throws ParseException {
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
        Main main = new Main();
        main.generator();
    }

    /**
     * Set the answer
     */
    public void setAnswer() {
        if (newGame()) {
            return;
        }
        if (!setUserNumber(input.getText().toCharArray())) {
            msgErrorNumber();
            return;
        }
        message.setText("Try again!");
        count++;
        for (int i = 0; i < userNumber.length; i++) {
            this.list.append(Integer.toString(userNumber[i]));
        }
        int cows = howCows(userNumber, unknownNumber);
        int bulls = howBulls(userNumber, unknownNumber);
        this.list.append("  Cows = " + cows
                + ", Bulls = " + bulls + "\n");
        if (bulls == 4) {
            msgWin();
            btn.setText("New game");
            flag = true;
        }
    }

    /**
     * Mask formatter for input only digits
     *
     * @param mask
     * @return
     * @throws ParseException
     */
    private MaskFormatter formatter(String mask) throws ParseException {
        MaskFormatter mf = new MaskFormatter(mask);
        mf.setValidCharacters("1234567890");
        return mf;
    }

    /**
     * Random number generator of 4 digits
     *
     * @return random number
     */
    private void generator() {
        Random rand = new Random();
        int k = unknownNumber.length;
        for (int i = k; i < 9; i++) {
            int j = rand.nextInt(10);
            if (j < k) {
                unknownNumber[j] = i + 1;
            }
        }
    }

    /**
     * How many digits encountered in the unknown number
     *
     * @param num - The number entered by the user
     * @return Number of cows
     */
    private int howCows(int[] userN, int[] unknownN) {
        int cows = 0;
        for (int i = 0; i < userN.length; i++) {
            for (int j = 0; j < userN.length; j++) {
                if (userN[i] == unknownN[j]) {
                    if (i == j) {
                        continue;
                    }
                    cows++;
                }
            }
        }
        return cows;
    }

    /**
     * How many digits coinciding with up position
     *
     * @param num - The number entered by the user
     * @return Number of bulls
     */
    private int howBulls(int[] userN, int[] unknownN) {
        int bulls = 0;
        for (int i = 0; i < userN.length; i++) {
            if (userN[i] == unknownN[i]) {
                bulls++;
            }
        }
        return bulls;
    }

    /**
     * Check the users number for repeated digids
     *
     * @param num - user namber
     * @return true if the digids are not repeated in the number
     */
    public boolean checkUserNumber(int[] num) {
        if (num[0] != num[1] & num[0] != num[2] & num[0] != num[3]) {
            if (num[1] != num[2] & num[1] != num[3]) {
                if (num[2] != num[3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Set to the variable users number and check for correct
     *
     * @param num - char array from JFormattedTextField
     * @return true if user number is correct
     */
    public boolean setUserNumber(char[] num) {
        for (int i = 0; i < num.length; i++) {
            int temp = Character.digit(num[i], 10);
            if (temp < 0) {
                return false;
            }
            userNumber[i] = temp;
        }
        return checkUserNumber(userNumber);
    }

    /**
     * Error message if user insert incorrect number
     */
    private void msgErrorNumber() {
        message.setText("Incorrect number!");
    }

    /**
     * Message about win
     */
    private void msgWin() {
        list.append("You won in " + count + " tries");
        message.setText("You Win!");
    }

    /**
     * Check flag for new game start
     * @return 
     */
    private boolean newGame() {
        if (flag) {
            count = 0;
            generator();
            input.setText("");
            list.setText("");
            flag = false;
            btn.setText("Enter");
            message.setText("Let`s play!");
            return true;
        }
        return false;
    }
}
