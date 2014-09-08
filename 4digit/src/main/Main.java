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
 * @author <strong >S.N. Frantsuzov, 2014</strong>
 * @version 1.0
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
     * Default constructor
     *
     * @throws ParseException - {@link java.text.ParseException}
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
     * @param args arguments of command string
     * @throws ParseException - {@link java.text.ParseException}
     */
    public static void main(String[] args) throws ParseException {
        Main main = new Main();
        main.generator();
    }

    /**
     * Set the answer
     */
    void setAnswer() {
        if (newGame()) {
            return;
        }
        if (!setUserNumber(getInput().getText().toCharArray())) {
            msgErrorNumber();
            return;
        }
        showMessage("Try again!");
        incCount();
        int[] un = getUserNumber();
        for (int i = 0; i < un.length; i++) {
            this.list.append(Integer.toString(un[i]));
        }
        int cows = howCows(un, getUnknownNumber());
        int bulls = howBulls(un, getUnknownNumber());
        this.list.append("  Cows = " + cows
                + ", Bulls = " + bulls + "\n");
        if (bulls == 4) {
            msgWin();
            buttonSetText("New game");
            flag = true;
        }
    }

    /**
     * How many digits encountered in the unknown number
     *
     * @param userN - input user number
     * @param unknownN - generate number
     * @return Number of cows
     */
    int howCows(int[] userN, int[] unknownN) {
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
     * @param userN - input user number
     * @param unknownN - generate number
     * @return Number of bulls
     */
    int howBulls(int[] userN, int[] unknownN) {
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
    boolean checkUserNumber(int[] num) {
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
    boolean setUserNumber(char[] num) {
        for (int i = 0; i < num.length; i++) {
            int temp = Character.digit(num[i], 10);
            if (temp < 0) {
                return false;
            }
            userNumber[i] = temp;
        }
        return checkUserNumber(getUserNumber());
    }

    /**
     * Error message if user insert incorrect number
     */
    private void msgErrorNumber() {
        showMessage("Incorrect number!");
    }

    /**
     * Message about win
     */
    private void msgWin() {
        list.append("You won in " + getCount() + " tries");
        showMessage("You Win!");
    }

    /**
     * Check flag for new game start
     *
     * @return
     */
    private boolean newGame() {
        if (flag) {
            setCount(0);
            generator();
            clearAllTextFields();
            flag = false;
            buttonSetText("Enter");
            showMessage("Let`s play!");
            return true;
        }
        return false;
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
        int k = getUnknownNumber().length;
        int[] tmp = new int[k];
        for (int i = k; i < 9; i++) {
            int j = rand.nextInt(10);
            if (j < k) {
                tmp[j] = i + 1;
            }
        }
        setUnknownNumber(tmp);
    }

    /**
     * Getter of the variable input
     *
     * @return value of the variable input
     */
    private JFormattedTextField getInput() {
        return input;
    }

    /**
     * Getter of the variable unknownNumber
     *
     * @return value of the variable unknownNumber
     */
    private int[] getUnknownNumber() {
        return unknownNumber;
    }

    /**
     * Getter of the variable userNumber
     *
     * @return value of the variable userNumber
     */
    private int[] getUserNumber() {
        return userNumber;
    }

    /**
     * Getter of the variable count
     *
     * @return value of the variable count
     */
    private int getCount() {
        return count;
    }

    /**
     * Setter of the variable count
     *
     * @param num
     */
    private void setCount(int num) {
        this.count = num;
    }

    /**
     * Increment the count
     */
    private void incCount() {
        this.count++;
    }

    /**
     * Clear all text fields for new game
     */
    private void clearAllTextFields() {
        input.setText("");
        list.setText("");
    }

    /**
     * Setter of the variable unknownNumber
     *
     * @param unknownNumber
     */
    private void setUnknownNumber(int[] unknownNumber) {
        this.unknownNumber = unknownNumber;
    }

    /**
     * Message show to user
     *
     * @param text
     */
    private void showMessage(String text) {
        this.message.setText(text);
    }

    /**
     * Button text change
     * @param text 
     */
    private void buttonSetText(String text) {
        this.btn.setText(text);
    }
}
