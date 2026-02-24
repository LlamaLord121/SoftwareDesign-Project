package Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class KeyboardIO implements ActionListener {

    private Map<String, JButton> keyMap = new HashMap<>();

    // Base key - standard size
    class GeneralKey extends JButton {
        public GeneralKey(String label) {
            super(label);
            setPreferredSize(new Dimension(45, 50));
            setOpaque(true);
        }
    }

    // Custom key (Enter/Backspace) - can override width
    class CustomKey extends GeneralKey {
        public CustomKey(String label, int width) {
            super(label);
            setPreferredSize(new Dimension(width, 50));
        }
    }

    public static void main(String[] args) {
        KeyboardIO keyboard = new KeyboardIO();
        keyboard.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new BoxLayout(keyboardPanel, BoxLayout.Y_AXIS));

        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};

        for (String row : rows) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
            for (char c : row.toCharArray()) { // Build the interperitable array
                GeneralKey button = new GeneralKey(String.valueOf(c));
                button.addActionListener(this);
                rowPanel.add(button);
                keyMap.put(String.valueOf(c), button);
            }
            keyboardPanel.add(rowPanel);
        }

        // Enter and Backspace on their own dedicated row, initialized seperately so they can't be locked or colored
        JPanel actionRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));

        CustomKey enterButton = new CustomKey("ENTER", 90); // 2x normal width
        enterButton.addActionListener(this);

        CustomKey backspaceButton = new CustomKey("⌫", 55); // standard width
        backspaceButton.addActionListener(this);

        actionRow.add(enterButton);
        actionRow.add(backspaceButton);
        keyboardPanel.add(actionRow);

        frame.getContentPane().add(keyboardPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String pressed = ((JButton) event.getSource()).getText();

        if (pressed.equals("ENTER")) {
            System.out.println("Enter");
            // Logic Hook
        } else if (pressed.equals("⌫")) {
            System.out.println("Backspace");
            // Logic Hook
        } else {
            System.out.println(pressed);
            // Logic Hook
        }
    }

    // Use to color the keys when they get locked
    public void colorKey(String letter, Color color) {
        if (keyMap.containsKey(letter)) {
            keyMap.get(letter).setBackground(color);
        }
    }
}